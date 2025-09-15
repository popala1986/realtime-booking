-- Usunięcie tabel, jeśli istnieją
DROP TABLE IF EXISTS reservation;
DROP TABLE IF EXISTS seat;
DROP TABLE IF EXISTS users;

-- Tworzenie tabeli users
CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    phone VARCHAR(20),          -- dodana kolumna phone
    enabled TINYINT DEFAULT 1,
    role VARCHAR(255) DEFAULT 'ROLE_USER'
) ENGINE=InnoDB;

CREATE TABLE user_roles (
    user_id BIGINT NOT NULL,
    roles VARCHAR(255) NOT NULL,
    PRIMARY KEY(user_id, roles),
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
) ENGINE=InnoDB;

-- Tworzenie tabeli seat
CREATE TABLE seat (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    row_num INT NOT NULL,
    seat_num INT NOT NULL,
    status ENUM('AVAILABLE','OCCUPIED','RESERVED') DEFAULT 'AVAILABLE'
) ENGINE=InnoDB;

-- Tworzenie tabeli reservation
CREATE TABLE reservation (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    seat_id BIGINT NOT NULL,
    reservation_time DATETIME NOT NULL,
    expires_at DATETIME NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    FOREIGN KEY (seat_id) REFERENCES seat(id) ON DELETE CASCADE
) ENGINE=InnoDB;