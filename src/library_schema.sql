CREATE TABLE USERS (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    full_name VARCHAR(255) NOT NULL,
    phone_number VARCHAR(50),
    user_type ENUM('author', 'admin', 'client') NOT NULL,
    CONSTRAINT users_user_type_check CHECK (user_type IN ('author', 'admin', 'client'))
);

-- Create AUTHORS table
CREATE TABLE AUTHORS (
    author_id INT PRIMARY KEY,
    FOREIGN KEY (author_id) REFERENCES USERS (user_id) ON DELETE CASCADE
);

-- Create ADMINS table
CREATE TABLE ADMINS (
    admin_id INT PRIMARY KEY,
    FOREIGN KEY (admin_id) REFERENCES USERS (user_id) ON DELETE CASCADE
);

-- Create CLIENTS table
CREATE TABLE CLIENTS (
    client_id INT PRIMARY KEY,
    FOREIGN KEY (client_id) REFERENCES USERS (user_id) ON DELETE CASCADE
);

-- Create BOOKS table
CREATE TABLE BOOKS (
    book_id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    stock INT DEFAULT 0,
    author_id INT NOT NULL,
    FOREIGN KEY (author_id) REFERENCES AUTHORS (author_id) ON DELETE CASCADE
);

-- Create ORDERS table
CREATE TABLE ORDERS (
    order_id INT AUTO_INCREMENT PRIMARY KEY,
    client_id INT NOT NULL,
    book_id INT NOT NULL,
    order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (client_id) REFERENCES CLIENTS (client_id) ON DELETE CASCADE,
    FOREIGN KEY (book_id) REFERENCES BOOKS (book_id) ON DELETE CASCADE
);

-- Create FEEDBACK table
CREATE TABLE FEEDBACK (
    feedback_id INT AUTO_INCREMENT PRIMARY KEY,
    client_id INT NOT NULL,
    author_id INT NOT NULL,
    feedback_message VARCHAR(4000),
    feedback_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (client_id) REFERENCES CLIENTS (client_id) ON DELETE CASCADE,
    FOREIGN KEY (author_id) REFERENCES AUTHORS (author_id) ON DELETE CASCADE
);
