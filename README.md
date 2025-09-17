# **Real-Time Seat Booking Application**

## **Opis Projektu**

Jest to aplikacja webowa do rezerwacji miejsc w czasie rzeczywistym, zaprojektowana z wykorzystaniem technologii **Spring Boot** i **WebSockets (STOMP)**. Aplikacja symuluje system rezerwacji kinowej lub teatralnej, umożliwiając wielu użytkownikom jednoczesne rezerwowanie miejsc. Główne założenie projektu to demonstracja efektywnej komunikacji w czasie rzeczywistym i synchronizacji stanu aplikacji między wieloma klientami.

---

## **Główne Funkcje**

- **Rezerwacja w czasie rzeczywistym**  
  Stan miejsc jest natychmiastowo synchronizowany między wszystkimi użytkownikami dzięki technologii WebSocket.

- **System uwierzytelniania**  
  Użytkownicy muszą być zalogowani, aby rezerwować miejsca (zastosowano Spring Security).

- **Wizualizacja miejsc**  
  Interfejs użytkownika w postaci siatki miejsc, które zmieniają kolor w zależności od ich statusu (dostępne, zarezerwowane).

- **Zarządzanie rezerwacjami**  
  Automatyczne usuwanie wygasłych rezerwacji po określonym czasie, co pozwala na zwolnienie miejsc.

- **Tokeny CSRF**  
  Zaimplementowano mechanizmy zabezpieczające przed atakami Cross-Site Request Forgery (CSRF).

---

## **Użyte Technologie**

### Backend

- **Spring Boot** – Framework do tworzenia aplikacji webowych w języku Java  
- **Spring WebSockets (STOMP)** – Protokół do komunikacji w czasie rzeczywistym  
- **Spring Security** – Moduł do obsługi uwierzytelniania i autoryzacji  
- **Spring Data JPA / Hibernate** – Warstwa dostępu do danych  
- **Lombok** – Biblioteka ułatwiająca generowanie kodu  
- **Baza danych** – _[np. H2, PostgreSQL]_  

### Frontend

- **Thymeleaf** – Silnik szablonów do generowania dynamicznych stron HTML  
- **JavaScript** – Logika po stronie klienta  
- **jQuery** – Ułatwienie manipulacji DOM i obsługi zdarzeń  
- **SockJS / Stomp.js** – Biblioteki do obsługi komunikacji WebSocket w przeglądarce  

---

## **Instrukcje Uruchomienia**

1. **Sklonuj repozytorium**  
   ```bash
   git clone [adres-repozytorium]
Otwórz projekt Zaimportuj projekt do swojego IDE (np. IntelliJ IDEA, Eclipse)

Konfiguracja bazy danych Upewnij się, że plik application.properties lub application.yml zawiera poprawne dane do połączenia z bazą danych

Uruchomienie Uruchom klasę główną main() swojej aplikacji

## **Autor**
Paweł Opala
- ** www.linkedin.com/in/paweł-opala
- ** https://github.com/popala1986/realtime-booking

