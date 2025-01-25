CREATE DATABASE 
    DEFAULT CHARACTER SET = 'utf8mb4';

    id INT AUTO_INCREMENT PRIMARY KEY,
    studentID VARCHAR(255),
    name VARCHAR(255),
    date VARCHAR(255),
    reason VARCHAR(255),
    course VARCHAR(255),
    section VARCHAR(255),
    );


CREATE DATABASE Rami;

USE Rami;




CREATE TABLE student (
    id INT AUTO_INCREMENT PRIMARY KEY,
    studentID VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
    date DATE NOT NULL,
    reason VARCHAR(255) NOT NULL,
    course VARCHAR(255) NOT NULL,
    section VARCHAR(255) NOT NULL
);

SELECT * FROM student;