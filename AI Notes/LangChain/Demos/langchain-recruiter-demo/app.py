from langchain.agents import create_agent
from langchain_google_genai import ChatGoogleGenerativeAI


def screen_candidate(profile: str, question: str) -> str:
    """Evaluate a candidate profile for recruiter and corporate trainer questions."""
    p = profile.lower()
    q = question.lower()

    # Role suitability
    if "suitable" in q or "fit" in q:
        if "senior corporate trainer" in q:
            gaps = []

            if "cloud" not in p or "not mentioned" in p:
                gaps.append("cloud expertise missing or unclear")

            if "microservices" not in p:
                gaps.append("microservices experience not mentioned")
            elif "basic exposure" in p or "basic" in p:
                gaps.append("advanced microservices depth needed")

            if "training" not in p and "trainer" not in p:
                gaps.append("corporate training experience missing")

            if "curriculum" not in p:
                gaps.append("curriculum design experience not mentioned")

            if "communication" not in p:
                gaps.append("communication strength not clearly mentioned")

            if gaps:
                return (
                    "Candidate is partially suitable for Senior Corporate Trainer role. "
                    "Better fit for Mid-Level Java Full Stack Trainer / SME support role. "
                    "Main gaps: " + ", ".join(gaps) + "."
                )

            return "Candidate appears suitable for Senior Corporate Trainer role based on the provided profile."

        if "java" in p and "spring boot" in p and "react" in p:
            return (
                "Candidate is suitable for a Java Full Stack role. "
                "Strong areas include Java, Spring Boot, React, REST API, and MySQL."
            )

        return "Candidate may not be a strong fit for the requested role based on the provided profile."

    # Skill gaps
    if "gap" in q or "missing" in q:
        missing = []

        if "aws" not in p and "azure" not in p and "gcp" not in p and "cloud" not in p:
            missing.append("cloud platform experience")

        if "microservices" not in p:
            missing.append("microservices")
        elif "basic exposure" in p or "basic" in p:
            missing.append("strong microservices depth")

        if "docker" not in p:
            missing.append("Docker")
        if "kubernetes" not in p and "k8s" not in p:
            missing.append("Kubernetes")
        if "training" not in p and "trainer" not in p:
            missing.append("corporate training experience")
        if "curriculum" not in p:
            missing.append("curriculum design")
        if "mentoring" not in p and "mentor" not in p:
            missing.append("mentoring experience")

        if missing:
            return "Missing or weak areas: " + ", ".join(missing) + "."

        return "No major skill gaps found from the provided profile."

    # Interview decision
    if "interview" in q or "l1" in q:
        return (
            "Yes, schedule L1 interview if the role is relevant. "
            "Focus on technical depth, training capability, communication, cloud basics, and microservices."
        )

    # Summary
    if "summary" in q or "summarize" in q:
        return "Profile reviewed. Candidate evaluation is based strictly on the pasted profile."

    # Default
    return (
        "Based on the provided profile, the candidate seems more suitable for a mid-level technical role "
        "unless stronger trainer leadership, cloud, and advanced architecture experience are explicitly mentioned."
    )


def extract_text(content) -> str:
    """Extract clean text from LangChain/Gemini response content."""
    if isinstance(content, str):
        return content

    if isinstance(content, list):
        parts = []
        for item in content:
            if isinstance(item, dict) and item.get("type") == "text":
                parts.append(item.get("text", ""))
            else:
                parts.append(str(item))
        return " ".join(part for part in parts if part).strip()

    return str(content)


# Gemini model
llm = ChatGoogleGenerativeAI(
    model="gemini-2.5-flash",
    temperature=0
)

agent = create_agent(
    model=llm,
    tools=[screen_candidate],
    system_prompt=(
        "You are an HR recruiter assistant for corporate trainer hiring. "
        "Use the screening tool and answer only from the pasted candidate profile. "
        "Do not invent skills that are not explicitly present."
    ),
)

print("\n=== Recruiter Screening Bot ===")
print("Paste the candidate profile below.")
print("When finished, type END on a new line.\n")

profile_lines = []
while True:
    line = input()
    if line.strip().upper() == "END":
        break
    profile_lines.append(line)

candidate_profile = "\n".join(profile_lines).strip()

if not candidate_profile:
    print("\nNo candidate profile was provided. Exiting.")
    raise SystemExit

print("\nCandidate profile loaded successfully.")
print("Now ask recruiter questions. Type 'exit' to quit.\n")

while True:
    user_input = input("Ask recruiter question: ").strip()

    if user_input.lower() == "exit":
        print("Goodbye!")
        break

    try:
        response = agent.invoke(
            {
                "messages": [
                    {
                        "role": "user",
                        "content": (
                            f"Candidate Profile:\n{candidate_profile}\n\n"
                            f"Recruiter Question: {user_input}"
                        ),
                    }
                ]
            }
        )

        print("\nAssistant:")
        print(extract_text(response["messages"][-1].content))
        print()

    except Exception as e:
        print("\nError:", str(e))
        print()