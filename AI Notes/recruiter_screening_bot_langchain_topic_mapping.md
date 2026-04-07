# Recruiter Screening Bot --- LangChain Topic Mapping

This project is a **Recruiter Screening Bot**.

It accepts: - Candidate profile - Recruiter questions

And uses: - LLM - Tool - Agent - System Prompt

to generate answers **strictly from the pasted profile only**.

------------------------------------------------------------------------

## 1) Agents and Tools

### Code Part

``` python
from langchain.agents import create_agent

agent = create_agent(
    model=llm,
    tools=[screen_candidate],
    system_prompt=(...)
)
```

### Why this comes under Agents and Tools

-   `create_agent(...)` creates the **LangChain Agent**
-   `tools=[screen_candidate]` gives the agent a **custom tool**
-   `screen_candidate()` is the **tool function**
-   The agent decides when to use the tool

### Real Meaning

This is a **tool-calling recruiter bot**.

The tool contains business rules: - suitability check - skill gap
check - interview decision - summary

------------------------------------------------------------------------

## 2) LLM Integration

``` python
from langchain_google_genai import ChatGoogleGenerativeAI

llm = ChatGoogleGenerativeAI(
    model="gemini-2.5-flash",
    temperature=0
)
```

This is the **LLM layer**.

------------------------------------------------------------------------

## 3) Prompt Engineering / System Prompt

``` python
system_prompt=(
    "You are an HR recruiter assistant for corporate trainer hiring. "
    "Use the screening tool and answer only from the pasted candidate profile. "
    "Do not invent skills that are not explicitly present."
)
```

This controls: - recruiter role - use pasted profile only - no
hallucination - no invented skills

------------------------------------------------------------------------

## 4) Tool Workflow / Business Rules

The `screen_candidate()` function handles: - suitability - skill gaps -
interview decision - summary - default recommendation

This is the **business rules engine**.

------------------------------------------------------------------------

## 5) Output Parsing

``` python
def extract_text(content) -> str:
```

This handles: - response cleanup - string extraction - list conversion -
final output formatting

------------------------------------------------------------------------

## 6) Human-in-the-Loop

``` python
while True:
    user_input = input("Ask recruiter question: ").strip()
```

This is the recruiter interaction loop.

------------------------------------------------------------------------

## Final Topic Mapping Summary

  Code Section                 LangChain Topic
  ---------------------------- --------------------
  `create_agent()`             Agents
  `tools=[screen_candidate]`   Tools
  `screen_candidate()`         Custom Tool
  `ChatGoogleGenerativeAI()`   LLM
  `system_prompt`              Prompt Engineering
  `extract_text()`             Output Parsing
  recruiter chat loop          Human-in-the-loop
