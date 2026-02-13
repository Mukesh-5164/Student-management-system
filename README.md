# Student Management System

Backend application built using Spring Boot and PostgreSQL.

## Features

- Student CRUD operations
- DTO mapping
- Validation
- Global exception handling
- Pagination and sorting
- Course – Student relationship
- User registration and login
- BCrypt password encryption
- JWT authentication (token generation)

## Tech Stack

- Java 25
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Hibernate
- Maven

## API Endpoints

### Auth

POST /auth/register  
POST /auth/login  

### Students

GET /detail/students?page=0&size=5&sortBy=id  
POST /detail/students  
PUT /detail/students/{id}  
DELETE /detail/delete/{id}  

## How to Run

1. Clone repo
2. Configure PostgreSQL in application.properties
3. Run Spring Boot application
4. Test APIs using Postman

---

Built by Mukesh
