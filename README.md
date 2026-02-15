# GitHub Repository Searcher

Spring Boot backend application to search GitHub repositories, store them in a database, and retrieve them using REST APIs.

---

## Tech Stack

- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- H2 Database
- Maven

---

## Features

- Search repositories from GitHub API
- Store repository data in database
- Retrieve stored repositories
- Filter by language
- Filter by minimum stars
- Prevent duplicate records

---

## API Endpoints


### 2. Get Stored Repositories

**GET**  
`/api/github/repositories`

Optional Query Parameters:

- language → Filter by programming language
- minStars → Minimum stars count

Examples:
/api/github/repositories
/api/github/repositories?language=Java
/api/github/repositories?minStars=50000


---

## Important (Beginner Tip)

Make sure:

- There are **three backticks** before `json`
- And **three backticks** after the JSON block

Like this:
{ ... }

If the closing ``` is missing → GitHub formatting becomes messy.

---

## After pasting

Save file → then run:
git add README.md
git commit -m "Updated API section"
git push

---

If you want, I can next give you:
**Final submission checklist (what interviewer will check in this project)** — very useful.
::contentReference[oaicite:0]{index=0}






### 1. Search Repositories

**POST**  
`/api/github/search`

Request Body:

```json
{
  "query": "spring boot",
  "language": "java",
  "sort": "stars"
}


\





