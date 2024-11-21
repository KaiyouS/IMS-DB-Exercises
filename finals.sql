CREATE DATABASE finals;
USE finals;

CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    lastname VARCHAR(25),
    firstname VARCHAR(25),
    email VARCHAR(25) UNIQUE,
    password VARCHAR(25)
);


CREATE TABLE Categories (
    category_id INT AUTO_INCREMENT PRIMARY KEY,
    category_name VARCHAR(50) NOT NULL
);

CREATE TABLE Suppliers (
    supplier_id INT AUTO_INCREMENT PRIMARY KEY,
    supplier_name VARCHAR(100) NOT NULL,
    contact_info VARCHAR(255)
);

CREATE TABLE Items (
    item_id INT AUTO_INCREMENT PRIMARY KEY,
    item_name VARCHAR(100) NOT NULL,
    description TEXT,
    category_id INT,
    unit_price DECIMAL(10 , 2 ) NOT NULL,
    quantity_on_hand INT NOT NULL,
    reorder_level INT,
    FOREIGN KEY (category_id)
        REFERENCES Categories (category_id)
);

CREATE TABLE Transactions (
    transaction_id INT AUTO_INCREMENT PRIMARY KEY,
    item_id INT,
    transaction_date DATETIME,
    quantity INT,
    transaction_type VARCHAR(20),
    notes TEXT,
    FOREIGN KEY (item_id)
        REFERENCES Items (item_id)
);

SELECT * FROM users;
Select * FROM Categories;


-- Insert sample users
INSERT INTO users (lastname, firstname, email, password)
VALUES
    ('Smith', 'John', 'john.smith@example.com', 'password123'),
    ('Doe', 'Jane', 'jane.doe@example.com', 'securepass'),
    ('Brown', 'Charlie', 'charlie.brown@example.com', 'mypassword'),
    ('Garcia', 'Maria', 'maria.garcia@example.com', 'pass456');

-- Insert sample categories
INSERT INTO Categories (category_name)
VALUES
    ('Electronics'),
    ('Furniture'),
    ('Clothing'),
    ('Toys');

-- Insert sample suppliers
INSERT INTO Suppliers (supplier_name, contact_info)
VALUES
    ('ABC Electronics', 'contact@abcelectronics.com'),
    ('HomeComfort', 'info@homecomfort.com'),
    ('FashionHub', 'support@fashionhub.com'),
    ('ToyWorld', 'sales@toyworld.com');

-- Insert sample items
INSERT INTO Items (item_name, description, category_id, unit_price, quantity_on_hand, reorder_level)
VALUES
    ('Laptop', 'High-performance laptop', 1, 999.99, 50, 10),
    ('Sofa', 'Comfortable leather sofa', 2, 499.99, 20, 5),
    ('T-shirt', 'Cotton T-shirt in various sizes', 3, 19.99, 100, 20),
    ('Action Figure', 'Popular superhero action figure', 4, 24.99, 200, 50);

-- Insert sample transactions
INSERT INTO Transactions (item_id, transaction_date, quantity, transaction_type, notes)
VALUES
    (1, '2024-11-14 10:30:00', 2, 'Sale', 'Sold 2 laptops'),
    (2, '2024-11-14 12:00:00', 1, 'Purchase', 'Restocked 1 sofa'),
    (3, '2024-11-14 15:45:00', 10, 'Sale', 'Sold 10 T-shirts'),
    (4, '2024-11-14 16:20:00', 5, 'Sale', 'Sold 5 action figures');
