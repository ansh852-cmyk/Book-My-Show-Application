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

