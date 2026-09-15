# 🔐 JobSecureWeb

A **Java Spring Boot Job Portal REST API** built using **Spring Data JPA and MySQL**.

JobSecureWeb provides APIs to create, read, update, delete, and search job postings. The project demonstrates how to build a backend application using Spring Boot, REST APIs, Spring Data JPA, Hibernate, and MySQL.

---

## 🚀 Features

* ✅ Create a new job posting
* ✅ Get all job postings
* ✅ Get a job posting by ID
* ✅ Update an existing job posting
* ✅ Delete a job posting
* ✅ Search jobs by title or description
* ✅ MySQL database integration
* ✅ Spring Data JPA repository
* ✅ Hibernate ORM
* ✅ RESTful APIs
* ✅ Maven project
* ✅ Postman API testing

---

## 🛠️ Technologies Used

| Technology        | Purpose                       |
| ----------------- | ----------------------------- |
| Java 23           | Programming Language          |
| Spring Boot 4.0.8 | Backend Framework             |
| Spring Web        | REST API development          |
| Spring Data JPA   | Database access               |
| Hibernate         | ORM                           |
| MySQL 8           | Database                      |
| Maven             | Build & Dependency Management |
| Postman           | API Testing                   |
| Git & GitHub      | Version Control               |
| IntelliJ IDEA     | Development Environment       |

---

## 📁 Project Structure

```text
JobSecureWeb
│
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── achyuta
│   │   │           └── JobSecureWeb
│   │   │               │
│   │   │               ├── controller
│   │   │               │   └── JobRestController.java
│   │   │               │
│   │   │               ├── model
│   │   │               │   └── JobPost.java
│   │   │               │
│   │   │               ├── repo
│   │   │               │   └── JobRepo.java
│   │   │               │
│   │   │               ├── service
│   │   │               │   └── JobService.java
│   │   │               │
│   │   │               └── JobSecureWebApplication.java
│   │   │
│   │   └── resources
│   │       └── application.properties
│   │
│   └── test
│
├── pom.xml
└── README.md
```

---

## 🏗️ Architecture

The application follows a simple layered architecture:

```text
Client / Postman
       │
       ▼
┌─────────────────────┐
│   REST Controller   │
│ JobRestController   │
└──────────┬──────────┘
           │
           ▼
┌─────────────────────┐
│       Service       │
│     JobService      │
└──────────┬──────────┘
           │
           ▼
┌─────────────────────┐
│     Repository      │
│      JobRepo        │
└──────────┬──────────┘
           │
           ▼
┌─────────────────────┐
│       MySQL         │
│    job_portal DB    │
└─────────────────────┘
```

### Layers

**Controller**

Handles HTTP requests and sends responses.

**Service**

Contains the application/business logic.

**Repository**

Uses Spring Data JPA to communicate with the database.

**Model**

Represents the job data stored in the database.

---

## 🗄️ Database

Database used:

```text
job_portal
```

Main table:

```text
jobs
```

### Jobs Table

| Column      | Type         | Description               |
| ----------- | ------------ | ------------------------- |
| id          | INT          | Job ID                    |
| title       | VARCHAR(100) | Job title                 |
| description | VARCHAR(500) | Job description           |
| experience  | INT          | Required experience       |
| skills      | JSON         | Required technical skills |

Example:

```sql
CREATE DATABASE job_portal;

USE job_portal;

CREATE TABLE jobs (
    id INT PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    description VARCHAR(500),
    experience INT NOT NULL,
    skills JSON
);
```

Example data:

```sql
INSERT INTO jobs
(id, title, description, experience, skills)
VALUES
(
    1,
    'Java Developer',
    'Must have good experience in core Java and advanced Java',
    2,
    '["Core Java", "J2EE", "Spring Boot", "Hibernate"]'
);
```

---

# 🔗 REST API Endpoints

Base URL:

```text
http://localhost:8080
```

---

## 1️⃣ Get All Jobs

### GET

```text
GET /jobPosts
```

Example:

```text
http://localhost:8080/jobPosts
```

Returns all available jobs.

---

## 2️⃣ Get Job By ID

### GET

```text
GET /jobPost/{postId}
```

Example:

```text
http://localhost:8080/jobPost/1
```

Returns the job with ID `1`.

---

## 3️⃣ Add New Job

### POST

```text
POST /jobPost
```

Example:

```text
http://localhost:8080/jobPost
```

### Request Body

```json
{
    "postId": 6,
    "postProfile": "Backend Developer",
    "postDesc": "Experience with Java and Spring Boot",
    "reqExperience": 2,
    "postTechStack": "[\"Java\", \"Spring Boot\", \"REST API\", \"MySQL\"]"
}
```

---

## 4️⃣ Update Job

### PUT

```text
PUT /jobPost
```

Example:

```text
http://localhost:8080/jobPost
```

### Request Body

```json
{
    "postId": 6,
    "postProfile": "Senior Backend Developer",
    "postDesc": "Experience with Java, Spring Boot and REST APIs",
    "reqExperience": 3,
    "postTechStack": "[\"Java\", \"Spring Boot\", \"REST API\", \"MySQL\", \"Docker\"]"
}
```

---

## 5️⃣ Delete Job

### DELETE

```text
DELETE /jobPost/{postId}
```

Example:

```text
http://localhost:8080/jobPost/6
```

Response:

```text
Deleted
```

---

## 6️⃣ Search Jobs

### GET

```text
GET /jobPosts/keyword/{keyword}
```

Example:

```text
http://localhost:8080/jobPosts/keyword/Java
```

The search checks the keyword against:

* Job title
* Job description

For example:

```text
Java
```

can return jobs containing `Java` in their title or description.

---

# ⚙️ Configuration

Configure the MySQL connection in:

```text
src/main/resources/application.properties
```

Example:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/job_portal
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

> ⚠️ Do not commit your real database password to GitHub. Use an environment variable or another secure configuration method.

---

# ▶️ How to Run

## 1. Clone the Repository

```bash
git clone https://github.com/AchyutaBiswal/JobSecureWeb.git
```

Move into the project:

```bash
cd JobSecureWeb
```

---

## 2. Configure MySQL

Make sure MySQL is running.

Create the database:

```sql
CREATE DATABASE job_portal;
```

Then update your database username and password in:

```text
application.properties
```

---

## 3. Build the Project

Using Maven:

```bash
mvn clean install
```

---

## 4. Run the Application

```bash
mvn spring-boot:run
```

Or run the main Spring Boot class from IntelliJ IDEA.

The application will start at:

```text
http://localhost:8080
```

---

# 🧪 Testing with Postman

You can test the REST APIs using Postman.

### GET All Jobs

```text
GET http://localhost:8080/jobPosts
```

### GET Job

```text
GET http://localhost:8080/jobPost/1
```

### POST Job

```text
POST http://localhost:8080/jobPost
```

### PUT Job

```text
PUT http://localhost:8080/jobPost
```

### DELETE Job

```text
DELETE http://localhost:8080/jobPost/1
```

### Search Job

```text
GET http://localhost:8080/jobPosts/keyword/Java
```

---

# 📚 What I Learned

Through this project, I practiced:

* Java backend development
* Spring Boot
* REST API development
* Spring Data JPA
* Hibernate ORM
* MySQL database integration
* Entity mapping
* Repository pattern
* Service layer
* Controller layer
* CRUD operations
* Query method creation
* API testing with Postman
* Git and GitHub

---

# 🔮 Future Improvements

The project can be extended with:

* 🔎 Advanced job search
* 📄 Pagination
* ↕️ Sorting
* 🎯 Experience-based filtering
* 📍 Job location
* 💼 Job type
* 💰 Salary range
* 🏢 Company information
* 👤 User authentication
* 🔐 Spring Security
* 📩 Job applications
* 📊 Application status
* ✅ Request validation
* ⚠️ Global exception handling
* 📦 DTO-based API responses

---

# 👨‍💻 Author

**Achyuta Biswal**

Java Full Stack Developer | Java Backend Developer

### Skills

```text
Java
Spring Boot
Spring Data JPA
REST APIs
MySQL
SQL
Git
GitHub
Postman
Maven
```

---

## ⭐ Project Status

🚧 **Currently under development**

The current version provides a functional Job Portal REST API with:

```text
Spring Boot
    +
Spring Data JPA
    +
Hibernate
    +
MySQL
    +
CRUD Operations
    +
Job Search
```

More features will be added as the project evolves.
