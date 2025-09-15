-- Dodanie użytkownika testowego
INSERT INTO users (email, password, first_name, last_name, enabled, role)
VALUES ('test@example.com', '$2a$10$7Q7gqV1/JZVq8l5Y1Qx9VeEphmDkZV8o9f4KfJ0Y6q5nRj1d0tV4a', 'Test', 'User', 1, 'ROLE_USER');

-- Dodanie miejsc
INSERT INTO seat (row_num, seat_num, status) VALUES
-- Rząd 1
(1, 1, 'AVAILABLE'), (1, 2, 'AVAILABLE'), (1, 3, 'AVAILABLE'), (1, 4, 'AVAILABLE'),
(1, 5, 'AVAILABLE'), (1, 6, 'AVAILABLE'), (1, 7, 'AVAILABLE'), (1, 8, 'AVAILABLE'),
-- Rząd 2
(2, 1, 'AVAILABLE'), (2, 2, 'AVAILABLE'), (2, 3, 'AVAILABLE'), (2, 4, 'AVAILABLE'),
(2, 5, 'AVAILABLE'), (2, 6, 'AVAILABLE'), (2, 7, 'AVAILABLE'), (2, 8, 'AVAILABLE'),
-- Rząd 3
(3, 1, 'AVAILABLE'), (3, 2, 'AVAILABLE'), (3, 3, 'AVAILABLE'), (3, 4, 'AVAILABLE'),
(3, 5, 'AVAILABLE'), (3, 6, 'AVAILABLE'), (3, 7, 'AVAILABLE'), (3, 8, 'AVAILABLE'),
-- Rząd 4
(4, 1, 'AVAILABLE'), (4, 2, 'AVAILABLE'), (4, 3, 'AVAILABLE'), (4, 4, 'AVAILABLE'),
(4, 5, 'AVAILABLE'), (4, 6, 'AVAILABLE'), (4, 7, 'AVAILABLE'), (4, 8, 'AVAILABLE'),
-- Rząd 5
(5, 1, 'AVAILABLE'), (5, 2, 'AVAILABLE'), (5, 3, 'AVAILABLE'), (5, 4, 'AVAILABLE'),
(5, 5, 'AVAILABLE'), (5, 6, 'AVAILABLE'), (5, 7, 'AVAILABLE'), (5, 8, 'AVAILABLE');