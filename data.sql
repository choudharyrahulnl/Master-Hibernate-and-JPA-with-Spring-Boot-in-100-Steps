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
INSERT INTO course(name,created_date,updated_date) VALUES ('Spring Boot',SYSDATE(),SYSDATE());
INSERT INTO course(name,created_date,updated_date) VALUES ('Angular',SYSDATE(),SYSDATE());


CREATE TABLE IF NOT EXISTS student (
     id INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
     name VARCHAR(255)
);
INSERT INTO student(name) VALUES ('Rahul Choudhary');
INSERT INTO student(name) VALUES ('Shalu Baliyan');
INSERT INTO student(name) VALUES ('Ravi Baswan');


CREATE TABLE IF NOT EXISTS passport (
     id INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
     number VARCHAR(255)
);
INSERT INTO passport(number) VALUES ('E5234');
INSERT INTO passport(number) VALUES ('T4253');
INSERT INTO passport(number) VALUES ('K8426');


CREATE TABLE IF NOT EXISTS review (
    id INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
    description VARCHAR(255)
);
INSERT INTO review(description) VALUES ('5 Star');
INSERT INTO review(description) VALUES ('3 Star');
INSERT INTO review(description) VALUES ('4 Star');