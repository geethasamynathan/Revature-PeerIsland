import requests
import json

OLLAMA_URL = "http://localhost:11434/api/generate"
MODEL_NAME = "llama3.2:1b"

def ask_llm(prompt: str) -> str:
    payload= {
        "model":MODEL_NAME,
        "prompt":prompt,
        "stream":False
    }
    
    try:
        response=requests.post(OLLAMA_URL,json=payload,timeout=120)
        response.raise_for_status()
        data=response.json()
        return data.get("response","No response generated.")
    except requests.exceptions.RequestException as e:
        return f"Request error: {e}"
    except json.JSONDecodeError as e:
        return f"JSON error: {e}"
    
def support_reply_demo():
    message=input("Enter customer issue")
    prompt = f"""
    You are a customer support assistant.
    Customer message :"{message}"
    
    Write a short,polite,professional reply.
    """
    
    print("\n Generated Reply : \n")
    print(ask_llm(prompt))
    
def summary_demo():
    text=input("paste paragragh to summarize: ")
    prompt = f"""
Summarize the following text in 3 simple bullet points:

{text}
""" 
    print("\n Summary \n")
    print(ask_llm(prompt))

def email_demo():
    topic = input("Enter the email topic")
    prompt = f"""
Write a professional email on this topic 
{topic}

Keep it short and clear.
"""

    print("Generated Email :\n ")
    print(ask_llm(prompt))


def main():
    while True:
        print("\n=== LLm Practice Menu ===")
        print("1. Customer support reply")
        print("2. Text Summary")
        print("3. Email writer")
        print("4. Exit")
        
        choice =input("Enter your choice: ")
        
        if choice == "1":
            support_reply_demo()
        elif choice =="2":
            summary_demo()
        elif choice =="3":
            email_demo()
        elif choice == "4":
            print("Exciting...")
            break
        else :
           print("Invalid choice.Try again.")
if __name__ == "__main__":
    main()
