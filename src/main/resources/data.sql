CREATE TABLE person (
    person_id INTEGER NOT NULL PRIMARY KEY,
    person_name VARCHAR(255) NOT NULL,
    person_location VARCHAR(255),
    person_birth_date TIMESTAMP
);

INSERT INTO person (person_id, person_name, person_location, person_birth_date)
VALUES (10001,'Rahul','Rotterdam',CURRENT_TIMESTAMP()),
       (10002,'James','Amsterdam',CURRENT_TIMESTAMP()),
       (10003,'Peter','Leiden',CURRENT_TIMESTAMP());