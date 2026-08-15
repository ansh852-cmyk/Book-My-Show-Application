# 🎬 BookMyShow — Movie Ticket Booking System


A full-stack movie ticket booking application built with **Java, Spring Boot, Spring Data JPA, MySQL, HTML, CSS, and JavaScript**. The application implements the core workflow of an online movie booking platform, including movie browsing, theatre and show management, seat selection, ticket booking, and admin operations.


## 🚀 Features


- 🎥 Browse and manage movies
- 🏢 Theatre and screen management
- 🎫 Create and manage movie shows
- 💺 View and select available seats
- 🎟️ Book movie tickets
- 👨‍💼 Admin panel for managing movies, theatres, screens, and shows
- 🔐 Request validation
- ⚠️ Centralized exception handling
- 🔄 Clean Controller → Service → Repository architecture
- 🗄️ MySQL database persistence
- 🌐 RESTful APIs
- 🐳 Docker support


## 🏗️ Architecture


```text
                         Client
                    HTML / CSS / JS
                           │
                           │ HTTP
                           ▼
                ┌─────────────────────┐
                │   Spring Boot API   │
                │    Controllers      │
                └──────────┬──────────┘
                           │
                           ▼
                ┌─────────────────────┐
                │    Service Layer    │
                │   Business Logic    │
                └──────────┬──────────┘
                           │
                           ▼
                ┌─────────────────────┐
                │  Repository Layer   │
                │   Spring Data JPA   │
                └──────────┬──────────┘
                           │
                           ▼
                     ┌───────────┐
                     │   MySQL   │
                     └───────────┘
🎟️ Booking Workflow
User
 │
 ▼
Browse Movies
 │
 ▼
Select Movie
 │
 ▼
Select Theatre
 │
 ▼
Select Show
 │
 ▼
View Available Seats
 │
 ▼
Select Seats
 │
 ▼
Create Booking
 │
 ▼
Validate Request
 │
 ▼
Check Seat Availability
 │
 ▼
Save Booking
 │
 ▼
Booking Confirmation
🧩 Backend Structure
Controller
    │
    ▼
Service
    │
    ▼
Repository
    │
    ▼
MySQL
Controller Layer

Handles HTTP requests, request mapping, validation, and responses.

Service Layer

Contains booking logic, validation rules, and application business logic.

Repository Layer

Handles database operations using Spring Data JPA.

🗄️ Main Domain Flow
Movie
  │
  ▼
Show
  │
  ▼
Screen
  │
  ▼
Theatre


Show
  │
  ▼
Seats
  │
  ▼
Booking
📡 REST APIs

Example movie APIs:

GET    /movies
GET    /movies/{id}
POST   /movies
PUT    /movies/{id}
DELETE /movies/{id}

Example booking APIs:

POST   /bookings
GET    /bookings/{id}

Example show APIs:

GET    /shows
GET    /shows/{id}
POST   /shows
PUT    /shows/{id}
DELETE /shows/{id}
⚠️ Exception Handling

The application handles errors through centralized exception handling to return meaningful HTTP responses.

Controller
    │
    ▼
Service
    │
    X
Exception
    │
    ▼
Global Exception Handler
    │
    ▼
HTTP Error Response

Examples include:

Movie not found
Show not found
Invalid booking request
Invalid seat
Missing required fields
Invalid request parameters
🛠️ Tech Stack
Technology	Purpose
Java	Backend development
Spring Boot	Backend framework
Spring Data JPA	Database access
Hibernate	ORM
MySQL	Database
REST APIs	Client-server communication
HTML	Frontend
CSS	Styling
JavaScript	Frontend functionality
Maven	Build and dependency management
Docker	Containerization
Git/GitHub	Version control
Postman	API testing
📂 Project Structure
BookMyShow/
│
├── src/
│   └── main/
│       ├── java/
│       │   └── ...
│       │       ├── controller/
│       │       ├── service/
│       │       ├── repository/
│       │       ├── entity/
│       │       ├── dto/
│       │       └── exception/
│       │
│       └── resources/
│           └── application.properties
│
├── pom.xml
├── Dockerfile
└── README.md
▶️ Run Locally
Prerequisites
Java 21+
Maven
MySQL
Git
Postman
Clone
git clone https://github.com/Suryaansh-R/BookMyShow.git
cd BookMyShow
Create Database
CREATE DATABASE BookMyShowDB;
Configure MySQL

Update application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/BookMyShowDB
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD


spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
Build
mvn clean package
Run
mvn spring-boot:run
🐳 Docker

Build the backend image:

docker build -t bookmyshow-backend .

Run the container:

docker run -p 8082:8082 bookmyshow-backend
🧪 API Testing

The APIs can be tested using Postman.

Recommended workflow:

Create Movie
     ↓
Create Theatre
     ↓
Create Screen
     ↓
Create Show
     ↓
Check Available Seats
     ↓
Book Seats
     ↓
Retrieve Booking
🔍 Important Backend Consideration

A movie booking system must handle cases where multiple users attempt to book the same seat.

User A ──────┐
             ▼
           Seat
             ▲
User B ──────┘

A production system would require stronger concurrency control such as database locking or distributed locking to prevent double booking under high concurrent traffic.

⚠️ Current Limitations

The current project focuses on the core booking workflow. Potential production-level improvements include:

Spring Security and JWT authentication
Role-based authorization
Payment gateway integration
Redis caching
Distributed locking for seat booking
Kafka-based asynchronous processing
Centralized logging
Monitoring
Automated integration testing
CI/CD
Cloud deployment
🔮 Future Improvements
Current System
     │
     ├── Movie Management
     ├── Theatre Management
     ├── Show Management
     ├── Seat Selection
     ├── Booking
     ├── REST APIs
     ├── JPA
     └── MySQL
          │
          ▼
Future
     ├── Spring Security
     ├── JWT
     ├── Payment Gateway
     ├── Redis
     ├── Distributed Locking
     ├── Kafka
     ├── CI/CD
     └── Cloud Deployment
🎯 What This Project Demonstrates
Java backend development
Spring Boot
REST API development
Spring Data JPA
MySQL database integration
Layered architecture
Entity relationships
Request validation
Exception handling
CRUD operations
Movie booking workflow
Seat availability management
Frontend-backend integration
Docker
API testing
📌 Project Status

Completed — Available for Further Enhancement

The project implements the core workflow of a movie ticket booking platform with a Spring Boot backend, MySQL persistence, REST APIs, frontend integration, validation, and exception handling.
