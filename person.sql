DROP DATABASE jpa;
CREATE DATABASE IF NOT EXISTS jpa;
USE jpa;

CREATE TABLE IF NOT EXISTS person (
    person_id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    person_name VARCHAR(255) NOT NULL,
    person_location VARCHAR(255),
    person_birth_date TIMESTAMP
    );

INSERT INTO person (person_name, person_location, person_birth_date)
VALUES ('Rahul','Rotterdam',CURRENT_TIMESTAMP()),
       ('James','Amsterdam',CURRENT_TIMESTAMP()),
       ('Peter','Leiden',CURRENT_TIMESTAMP());