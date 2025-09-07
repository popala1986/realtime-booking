# RealTimeBooking

## Opis projektu / Project Description
Projekt 1: System Rezerwacji Miejsc w Czasie Rzeczywistym (Monolit z elementami live)  
Project 1: Real-Time Booking System (Monolith with live elements) 

**Koncepcja / Concept:**  
Aplikacja webowa, która pozwala użytkownikom na rezerwację miejsc w czasie rzeczywistym, np. w restauracji, sali kinowej czy na wspólnym miejscu parkingowym.  
Kluczowym elementem jest to, że gdy jeden użytkownik rezerwuje miejsce, staje się ono natychmiast niedostępne dla innych, bez potrzeby odświeżania strony.  

A web application that allows users to book spots in real-time, e.g., in a restaurant, cinema hall, or shared parking space.  
The key feature is that when one user books a spot, it immediately becomes unavailable for others without needing to refresh the page.

## Technologie / Technologies
- **Spring Web** – Niezbędne do tworzenia aplikacji webowych i kontrolerów REST.  
  Essential for building web applications and REST controllers.
- **Spring Data JPA** – Do komunikacji z bazą danych za pomocą encji.  
  For communicating with the database using entities.
- **MySQL Driver** – Sterownik do połączenia z bazą MySQL.  
  Driver to connect with a MySQL database.
- **WebSocket** – Do komunikacji w czasie rzeczywistym.  
  For real-time communication.
- **Spring Security** – Do zabezpieczenia aplikacji (logowanie, autoryzacja).  
  For securing the application (login, authorization).
