# 📘 LangChain Fundamentals Notes

## Topics Covered
- What is LangChain?
- Architecture overview
- LLM providers
- Prompts and Prompt Templates
- Chains and Sequential Processing
- Simple Chains vs Sequential Chains
- LLMChain and TransformChain
- Real-world use case: Candidate screening bot
- Step-by-step working flow

---

## 1) What is LangChain?
LangChain is an open-source framework used to build **LLM-powered applications and agents**.

It helps connect:
- prompts
- models
- tools
- retrievers
- databases
- memory
- output formatting

> **Simple definition:** A framework to build AI chatbots, RAG systems, HR bots, and multi-step workflows.

---

## 2) Architecture Overview
```text
User
 ↓
UI / API
 ↓
Prompt Template
 ↓
LLM Provider
 ↓
Chain / Agent Logic
 ↓
Tools / DB / APIs
 ↓
Output Formatter
 ↓
Final Response
```

### How it works
1. User sends input
2. Prompt template builds instruction
3. Model processes it
4. Chain controls multi-step flow
5. Tools or retrieval fetch extra data
6. Final structured response is returned

---

## 3) LLM Providers
LangChain supports multiple providers through a common interface.

Examples:
- OpenAI
- Anthropic
- Google
- Local open-source models

### Why useful?
Same workflow can switch providers with minimal code changes.

---

## 4) Prompts and Prompt Templates
### Prompt
A direct instruction sent to the model.

Example:
`Summarize this resume for recruiter review.`

### Prompt Template
Reusable prompt with variables.

```text
You are an HR assistant.
Job role: {job_role}
Resume: {resume}
Question: {question}
```

### Benefits
- reusable
- dynamic
- testable
- production-friendly

---

## 5) Chains and Sequential Processing
A chain links multiple steps.

### Example workflow
1. Extract skills
2. Compare with JD
3. Generate recruiter recommendation

This is useful for complex business workflows.

---

## 6) Simple Chain vs Sequential Chain
### Simple Chain
One-step task.

Example:
`Summarize candidate profile`

### Sequential Chain
Multi-step workflow.

Example:
1. Read resume
2. Extract skills
3. Match JD
4. Recommend L1

> **Simple = one step**
> **Sequential = multiple connected steps**

---

## 7) LLMChain
Classic prompt + model pattern.

### Flow
- Prompt template
- Input values
- LLM call
- Response

### Example
`Extract 5 skills from this resume.`

---

## 8) TransformChain
Used to transform data before or after model call.

### Example
Raw PDF text → cleaned structured resume text

Useful for:
- cleaning spacing
- splitting sections
- extracting fields

---

## 9) Real-World Use Case – Candidate Screening Bot
### Business Need
Recruiters want quick answers:
- Is candidate suitable?
- Missing skills?
- Seniority?
- L1 recommendation?

### Architecture
```text
Recruiter
 ↓
Resume Upload
 ↓
Transform Resume Text
 ↓
Prompt Template
 ↓
LLM
 ↓
Sequential Steps
   1. Extract skills
   2. Match JD
   3. Recommend interview
 ↓
Recruiter Report
```

---

## 10) Step-by-Step Working
### Step 1: Upload Resume
PDF or DOCX resume enters system.

### Step 2: Transform Data
Clean text and split sections.

### Step 3: Build Prompt
```text
Role: Java Full Stack
Mandatory skills: Java, Spring Boot, React, MySQL
Resume: {resume_text}
Provide matched, missing, seniority, recommendation.
```

### Step 4: LLM Processing
Model analyzes the resume.

### Step 5: Sequential Steps
- extract skills
- compare skills
- generate recommendation

### Step 6: Output
- matched skills
- missing skills
- seniority
- interview recommendation

---

## 11) Good vs Bad Usage
### ✅ Good
Split tasks into clear chains.

### ❌ Bad
One huge prompt mixing:
- technical fit
- salary fit
- retention prediction
- communication
- culture fit

This becomes hard to debug.

---

## 12) Golden Rule
> **LangChain = Prompt + Model + Chain + Tools + Output**

### Final Formula
**Input → Prompt → Model → Chain → Tools → Response**

