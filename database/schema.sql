-- Tạo database
CREATE DATABASE IF NOT EXISTS pttk_cinema CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE pttk_cinema;

-- Bảng users
CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(20) NOT NULL DEFAULT 'user',
    full_name VARCHAR(100),
    email VARCHAR(100),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Bảng movies
CREATE TABLE IF NOT EXISTS movies (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(200) NOT NULL,
    category VARCHAR(100),
    description TEXT,
    duration INT NOT NULL COMMENT 'Thời lượng tính bằng phút',
    age_rating INT NOT NULL COMMENT 'Độ tuổi',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Thêm user quản lý mẫu
INSERT INTO users (username, password, role, full_name, email) 
VALUES ('admin', 'admin123', 'manager', 'Quản lý hệ thống', 'admin@cinema.com')
ON DUPLICATE KEY UPDATE username=username;

-- Thêm user thường mẫu
INSERT INTO users (username, password, role, full_name, email) 
VALUES ('user', 'user123', 'user', 'Người dùng', 'user@cinema.com')
ON DUPLICATE KEY UPDATE username=username;

