import os
from typing import List

from langchain_google_genai import ChatGoogleGenerativeAI, GoogleGenerativeAIEmbeddings
from langchain_community.document_loaders import PyPDFLoader, TextLoader
from langchain_text_splitters import RecursiveCharacterTextSplitter
from langchain_community.vectorstores import FAISS
from langchain_core.messages import SystemMessage, HumanMessage, AIMessage


# =========================================================
# 1. API KEY SETUP
# =========================================================
GEMINI_API_KEY = os.getenv("GEMINI_API_KEY") or os.getenv("GOOGLE_API_KEY")

if not GEMINI_API_KEY:
    raise ValueError("Set GEMINI_API_KEY or GOOGLE_API_KEY in your environment.")


# =========================================================
# 2. LOAD DOCUMENTS
# =========================================================
def load_documents() -> List:
    docs = []

    pdf_files = [
        "knowledge_base/leave_policy.pdf",
        "knowledge_base/attendance_policy.pdf",
    ]

    text_files = [
        "knowledge_base/benefits_policy.txt",
    ]

    for pdf in pdf_files:
        if os.path.exists(pdf):
            loader = PyPDFLoader(pdf)
            docs.extend(loader.load())

    for txt in text_files:
        if os.path.exists(txt):
            loader = TextLoader(txt, encoding="utf-8")
            docs.extend(loader.load())

    return docs


# =========================================================
# 3. SPLIT DOCUMENTS INTO CHUNKS
# =========================================================
def split_documents(docs: List):
    splitter = RecursiveCharacterTextSplitter(
        chunk_size=1000,
        chunk_overlap=150
    )
    return splitter.split_documents(docs)


# =========================================================
# 4. CREATE EMBEDDINGS MODEL
# =========================================================
def get_embeddings():
    return GoogleGenerativeAIEmbeddings(
        model="models/gemini-embedding-001",
        google_api_key=GEMINI_API_KEY
    )


# =========================================================
# 5. BUILD / LOAD VECTOR STORE
# =========================================================
def build_vector_store(chunks):
    embeddings = get_embeddings()
    vectorstore = FAISS.from_documents(chunks, embeddings)
    return vectorstore


# =========================================================
# 6. CREATE GEMINI CHAT MODEL
# =========================================================
def get_llm():
    return ChatGoogleGenerativeAI(
        model="gemini-2.5-flash",
        temperature=0,
        google_api_key=GEMINI_API_KEY
    )


# =========================================================
# 7. SIMPLE MEMORY FOR CONVERSATION
# =========================================================
class ConversationMemory:
    def __init__(self, max_turns: int = 6):
        self.history = []
        self.max_turns = max_turns

    def add_user_message(self, text: str):
        self.history.append(HumanMessage(content=text))
        self._trim()

    def add_ai_message(self, text: str):
        self.history.append(AIMessage(content=text))
        self._trim()

    def get_history(self):
        return self.history

    def _trim(self):
        # keep only the latest few turns
        if len(self.history) > self.max_turns * 2:
            self.history = self.history[-self.max_turns * 2:]


# =========================================================
# 8. RETRIEVE RELEVANT DOCUMENT CHUNKS
# =========================================================
def retrieve_context(vectorstore, query: str, k: int = 4) -> str:
    docs = vectorstore.similarity_search(query, k=k)
    return "\n\n".join([doc.page_content for doc in docs])


# =========================================================
# 9. ASK GEMINI USING RAG + MEMORY
# =========================================================
def ask_hr_bot(llm, vectorstore, memory: ConversationMemory, user_question: str) -> str:
    retrieved_context = retrieve_context(vectorstore, user_question, k=4)

    system_prompt = """
You are an HR Policy Assistant for employees.

Rules:
1. Answer only from the provided company policy context.
2. If the answer is not found in the context, say:
   "I could not find that in the uploaded HR policy documents."
3. Use conversation history for follow-up understanding.
4. Be clear, professional, and concise.
"""

    messages = [
        SystemMessage(content=system_prompt),
        SystemMessage(content=f"Retrieved Policy Context:\n{retrieved_context}")
    ]

    # add previous chat history
    messages.extend(memory.get_history())

    # add latest question
    messages.append(HumanMessage(content=user_question))

    response = llm.invoke(messages)

    answer = response.content if isinstance(response.content, str) else str(response.content)

    memory.add_user_message(user_question)
    memory.add_ai_message(answer)

    return answer


# =========================================================
# 10. MAIN APP
# =========================================================
def main():
    print("Loading documents...")
    docs = load_documents()

    if not docs:
        print("No documents found in knowledge_base/.")
        return

    print(f"Loaded {len(docs)} document pages/records.")

    print("Splitting documents into chunks...")
    chunks = split_documents(docs)
    print(f"Created {len(chunks)} chunks.")

    print("Building vector store...")
    vectorstore = build_vector_store(chunks)

    print("Loading Gemini model...")
    llm = get_llm()

    memory = ConversationMemory(max_turns=6)

    print("\n=== HR Policy Assistant ===")
    print("Ask questions about company HR policies. Type 'exit' to quit.\n")

    while True:
        user_question = input("You: ").strip()

        if user_question.lower() == "exit":
            print("Goodbye!")
            break

        try:
            answer = ask_hr_bot(llm, vectorstore, memory, user_question)
            print(f"\nBot: {answer}\n")
        except Exception as e:
            print(f"\nError: {e}\n")


if __name__ == "__main__":
    main()