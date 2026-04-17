-- Create database
CREATE DATABASE student;

-- Use database
USE student;

-- Create table
CREATE TABLE studentdata (
  id INT AUTO_INCREMENT PRIMARY KEY,
  rollno INT NOT NULL,
  name VARCHAR(100) NOT NULL,
  class VARCHAR(100) NOT NULL,
  address VARCHAR(200) NOT NULL
);

-- Insert sample data
INSERT INTO studentdata (rollno, name, class, address)
VALUES (45, 'Priya Khade', 'TE A', 'Somwar Peth');