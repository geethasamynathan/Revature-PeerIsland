# 📘Hallucinations in Prompt Engineering

## 1) What is Hallucination?
Hallucination means the AI generates **incorrect, invented, or misleading information** that sounds believable.

> **Simple definition:** AI confidently gives wrong or made-up output.

This can happen in text generation, coding, analytics, legal summaries, medical explanations, and chatbots.

---

## 2) Why It Happens
Hallucinations usually happen when prompts are:
- Too vague
- Missing context
- Asking for unavailable data
- Too broad
- Speculative
- Not grounded in sources

### Bad Example
`Tell me the exact revenue of a private startup in 2025.`

The AI may invent numbers.

---

## 3) Why Use Hallucination Control?
We do **not use hallucinations intentionally**.
We use prompt engineering to **reduce or prevent hallucinations**.

### Benefits
- Better factual correctness
- Better trust
- Safer enterprise automation
- Better coding reliability
- Reduced legal/medical risks

---

## 4) How to Reduce Hallucinations

### A) Source Constraint
`Answer only from the provided document. If not found, say “Not mentioned.”`

### B) No Guessing Rule
`If unsure, clearly say you do not know.`

### C) Step-by-Step Reasoning
`First extract facts, then summarize, then conclude.`

### D) Structured Output
Use sections:
- Known facts
- Assumptions
- Missing information

### E) Retrieval / Grounding
`Based only on this PDF, summarize the customer complaints.`

---

## 5) Where to Use
- HR screening bots
- Coding assistants
- Medical chatbots
- Legal contract review
- Business reporting
- Analytics dashboards

---

## 6) Real-World Example – HR Screening Bot
### Bad Prompt
`Is this candidate good for senior architect?`

AI may assume skills not present.

### Better Prompt
`Evaluate only the skills explicitly mentioned in the resume. Separate proven skills and missing evidence.`

**Why it works:**
Prevents assumptions about cloud, architecture, leadership, and microservices.

---

## 7) Real-World Example – Coding Assistant
### Bad Prompt
`Generate payment gateway integration code.`

Risk:
- Fake SDK methods
- Wrong endpoints
- Outdated syntax

### Better Prompt
`Use only official Razorpay Java SDK syntax. If uncertain, mention verification needed.`

---

## 8) Real-World Example – Business Analytics Bot
### Bad Prompt
`Which product had the highest revenue growth?`

Without data, AI may invent product names.

### Better Prompt
`Use only uploaded MySQL sales data. If data is missing, ask for the sales table.`

---

## 9) Reusable Anti-Hallucination Templates
- Answer only from provided content
- If unavailable, say “I don’t know”
- Mention evidence used
- Use official syntax only
- Do not infer missing skills

---

## 10) Golden Rule
> **The more grounded the prompt, the less the hallucination.**

### Final Formula
**Context + source + no guessing rule + validation format = safer AI**

