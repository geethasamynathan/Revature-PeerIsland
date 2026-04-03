import requests

OLLAMA_URL = "http://localhost:11434/api/generate"
MODEL_NAME = "gemma3:4b"

def generate_reply(customer_message):
    prompt = f"""
You are a helpful customer support assistant.

Customer message:
"{customer_message}"

Task:
Write a professional reply.
Rules:
1. Apologize politely if needed.
2. Acknowledge the issue clearly.
3. Give a helpful next step.
4. Keep the response simple and friendly.
5. Keep it under 120 words.
"""

    payload = {
        "model": MODEL_NAME,
        "prompt": prompt,
        "stream": False
    }

    response = requests.post(OLLAMA_URL, json=payload)

    if response.status_code == 200:
        data = response.json()
        return data["response"]
    else:
        return f"Error: {response.text}"

def main():
    print("=== Beginner LLM Demo ===")
    msg = input("Enter customer issue: ")
    result = generate_reply(msg)

    print("\n=== Generated Reply ===")
    print(result)

if __name__ == "__main__":
    main()