DROP DATABASE IF EXISTS jpa_in_depth;
CREATE DATABASE IF NOT EXISTS jpa_in_depth;
USE jpa_in_depth;

# CREATE TABLE IF NOT EXISTS course (
#     id INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
#     name VARCHAR(255),
#     price DOUBLE,
#     created_date DATE,
#     updated_date DATE
# );
#
# INSERT INTO course(name,price,created_date,updated_date) VALUES ('AWS',499.00,SYSDATE(),SYSDATE());


CREATE TABLE IF NOT EXISTS course (
       id INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
       name VARCHAR(255),
       created_date DATE,
       updated_date DATE
);

INSERT INTO course(name,created_date,updated_date) VALUES ('AWS',SYSDATE(),SYSDATE());


CREATE TABLE IF NOT EXISTS student (
     id INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
     name VARCHAR(255)
);

INSERT INTO student(name) VALUES ('Rahul Choudhary');
