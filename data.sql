DROP DATABASE IF EXISTS jpa_in_depth;
CREATE DATABASE IF NOT EXISTS jpa_in_depth;
USE jpa_in_depth;

SET FOREIGN_KEY_CHECKS=0;

# CREATE TABLE IF NOT EXISTS course (
#     id INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
#     name VARCHAR(255),
#     price DOUBLE,
#     created_date DATE,
#     updated_date DATE
# );
#
# INSERT INTO course(name,price,created_date,updated_date) VALUES ('AWS',499.00,SYSDATE(),SYSDATE());

DROP TABLE IF EXISTS course;
CREATE TABLE IF NOT EXISTS course (
       id INTEGER NOT NULL AUTO_INCREMENT,
       name VARCHAR(255),
       created_date DATE,
       updated_date DATE,
       PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;;
INSERT INTO course(name,created_date,updated_date) VALUES ('AWS',SYSDATE(),SYSDATE());
INSERT INTO course(name,created_date,updated_date) VALUES ('Spring Boot',SYSDATE(),SYSDATE());
INSERT INTO course(name,created_date,updated_date) VALUES ('Angular',SYSDATE(),SYSDATE());




DROP TABLE IF EXISTS passport;
CREATE TABLE IF NOT EXISTS passport (
                                        id INTEGER NOT NULL AUTO_INCREMENT,
                                        number VARCHAR(255),
                                        PRIMARY KEY (`id`),
                                        UNIQUE KEY `UK_number` (`number`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;;
INSERT INTO passport(number) VALUES ('E5234');
INSERT INTO passport(number) VALUES ('T4253');
INSERT INTO passport(number) VALUES ('K8426');




DROP TABLE IF EXISTS student;
CREATE TABLE IF NOT EXISTS student (
     id INTEGER NOT NULL AUTO_INCREMENT,
     name VARCHAR(255),
     passport_id INTEGER,
     PRIMARY KEY (`id`),
     CONSTRAINT `FK_passport_id` FOREIGN KEY (`passport_id`) REFERENCES `passport` (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;;
INSERT INTO student(name,passport_id) VALUES ('Rahul Choudhary',1);
INSERT INTO student(name,passport_id) VALUES ('Shalu Baliyan',2);
INSERT INTO student(name,passport_id) VALUES ('Ravi Baswan',3);




CREATE TABLE IF NOT EXISTS review (
    id INTEGER NOT NULL AUTO_INCREMENT,
    rating VARCHAR(255),
    description VARCHAR(255),
    PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;;
INSERT INTO review(rating,description) VALUES ('5','Great Course');
INSERT INTO review(rating,description) VALUES ('3','Nice Course');
INSERT INTO review(rating,description) VALUES ('4','Good Course');


SET FOREIGN_KEY_CHECKS=1;