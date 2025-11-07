🌐 Real-Time Seat Booking Application
📌 Project Description
This is a web application for real-time seat booking, designed using Spring Boot and WebSockets (STOMP). It simulates a cinema or theater reservation system, allowing multiple users to book seats simultaneously. The main goal of the project is to demonstrate effective real-time communication and state synchronization between multiple clients.

🚀 Main Features
Real-time booking: Instant seat status updates across all users via WebSocket.

Authentication system: Users must log in to book seats (powered by Spring Security).

Seat visualization: Interactive seat grid with dynamic color changes based on status (available, reserved).

Reservation management: Automatic expiration of reservations after a set time to free up seats.

CSRF protection: Security mechanisms against Cross-Site Request Forgery attacks.

🛠️ Technologies Used
🔧 Backend
Spring Boot – Java framework for building web applications.

Spring WebSockets (STOMP) – Real-time communication protocol.

Spring Security – Authentication and authorization module.

Spring Data JPA / Hibernate – Data access layer.

Lombok – Code generation helper.

MySQL – Relational database.

🎨 Frontend
Thymeleaf – Template engine for dynamic HTML rendering.

JavaScript – Client-side logic.

jQuery – Simplified DOM manipulation and event handling.

SockJS / Stomp.js – WebSocket communication libraries for the browser.

📦 How to Run
Clone the repository

bash
git clone https://github.com/popala1986/realtime-booking
Open the project Import into your IDE (e.g., IntelliJ IDEA, Eclipse).

Configure the database Ensure application.properties or application.yml contains correct database credentials.

Run the application Launch the main class with the main() method.

👤 Author
Paweł Opala
