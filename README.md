# 🎓 Student Management System (Spring Boot)

A RESTful backend application built using Spring Boot that allows users to manage student data with full CRUD operations. This project demonstrates clean architecture, exception handling, validation, and MySQL integration.

---

## 🚀 Features

* ✅ Create, Read, Update, Delete (CRUD) operations
* ✅ REST API using Spring Boot
* ✅ MySQL database integration
* ✅ DTO-based architecture (clean code)
* ✅ Global exception handling
* ✅ Input validation (email, empty fields, etc.)
* ✅ Tested using Postman

---

## 🛠️ Tech Stack

* Java 17
* Spring Boot
* Spring Data JPA
* MySQL
* Lombok
* Maven

---

## 📁 Project Structure

```
com.goyal.studentmanagement
│
├── controller      # API endpoints
├── service         # Business logic
├── repository      # Database layer
├── model           # Entity classes
├── dto             # Data Transfer Objects
├── exception       # Exception handling
```

---

## ⚙️ Setup & Installation

### 1. Clone the repository

```
git clone https://github.com/your-username/student-management.git
cd student-management
```

---

### 2. Configure Database

Open `application.properties` and update:

```
spring.datasource.url=jdbc:mysql://localhost:3306/student_db
spring.datasource.username=your_username
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

### 3. Create Database

```
CREATE DATABASE student_db;
```

---

### 4. Run Application

Run the main class:

```
StudentManagementApplication.java
```

App will start at:

```
http://localhost:8080
```

---

## 📌 API Endpoints

| Method | Endpoint       | Description       |
| ------ | -------------- | ----------------- |
| POST   | /students      | Create student    |
| GET    | /students      | Get all students  |
| GET    | /students/{id} | Get student by ID |
| PUT    | /students/{id} | Update student    |
| DELETE | /students/{id} | Delete student    |

---

## 🧪 Sample Request (POST)

```
POST /students
```

```json
{
  "name": "Goyal",
  "email": "goyal@gmail.com",
  "course": "Engineering"
}
```

---

## ❗ Validation Example

```json
{
  "name": "",
  "email": "abc",
  "course": ""
}
```

### Response:

```json
{
  "name": "Name cannot be empty",
  "email": "Invalid email format",
  "course": "Course cannot be empty"
}
```

---

## ⚠️ Error Handling Example

```
GET /students/99
```

```json
{
  "timestamp": "2026-03-30T...",
  "message": "Student not found with id 99",
  "status": 404
}
```

---

## 📬 Testing

Use Postman to test APIs.

---

## 📌 Future Improvements

* 🔹 Swagger API documentation
* 🔹 Authentication (JWT)
* 🔹 Role-based access control
* 🔹 Frontend integration (Flutter)
* 🔹 Deployment on cloud

---

## 👨‍💻 Author

**Raunit Goyal **
Engineering Student

---

## ⭐ If you like this project

Give it a ⭐ on GitHub!
