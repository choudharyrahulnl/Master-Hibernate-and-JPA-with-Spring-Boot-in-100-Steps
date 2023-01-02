
DROP TABLE IF EXISTS course;
CREATE TABLE IF NOT EXISTS course (
       id INTEGER NOT NULL AUTO_INCREMENT,
       name VARCHAR(255),
       created_date DATE DEFAULT CURRENT_DATE,
       updated_date DATE DEFAULT CURRENT_DATE,
       is_deleted boolean DEFAULT FALSE,
       PRIMARY KEY (`id`)
);
INSERT INTO course(name) VALUES ('AWS Cloud');
INSERT INTO course(name) VALUES ('Spring Boot');
INSERT INTO course(name) VALUES ('Angular');
INSERT INTO course(name) VALUES ('Azure Cloud');




DROP TABLE IF EXISTS passport;
CREATE TABLE IF NOT EXISTS passport (
      id INTEGER NOT NULL AUTO_INCREMENT,
      number VARCHAR(255) UNIQUE ,
      PRIMARY KEY (`id`)
);
INSERT INTO passport(number) VALUES ('E5234');
INSERT INTO passport(number) VALUES ('T4253');
INSERT INTO passport(number) VALUES ('K8426');
INSERT INTO passport(number) VALUES ('S1423');




DROP TABLE IF EXISTS student;
CREATE TABLE IF NOT EXISTS student (
     id INTEGER NOT NULL AUTO_INCREMENT,
     name VARCHAR(255),
     passport_id INTEGER,
     PRIMARY KEY (`id`),
     CONSTRAINT `FK_passport_id` FOREIGN KEY (`passport_id`) REFERENCES `passport` (`id`)
);
INSERT INTO student(name,passport_id) VALUES ('Rahul Choudhary',1);
INSERT INTO student(name,passport_id) VALUES ('Shalu Baliyan',2);
INSERT INTO student(name,passport_id) VALUES ('Ravi Baswan',3);
INSERT INTO student(name,passport_id) VALUES ('Vignesh Laxman',4);



DROP TABLE IF EXISTS review;
CREATE TABLE IF NOT EXISTS review (
    id INTEGER NOT NULL AUTO_INCREMENT,
    rating VARCHAR(255),
    description VARCHAR(255),
    course_id INTEGER,
    PRIMARY KEY (`id`),
    CONSTRAINT `FK_course_id` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`)
);
INSERT INTO review(rating,description,course_id) VALUES ('5','Great Course',1);
INSERT INTO review(rating,description,course_id) VALUES ('3','Nice Course',2);
INSERT INTO review(rating,description,course_id) VALUES ('4','Good Course',3);
INSERT INTO review(rating,description,course_id) VALUES ('5','Awesome Course',1);



DROP TABLE IF EXISTS student_course;
CREATE TABLE IF NOT EXISTS student_course (
    student_id bigint not null,
    course_id bigint not null,
    CONSTRAINT UK_student_course UNIQUE  (`student_id`,`course_id`)
);
INSERT INTO student_course(student_id, course_id) VALUES (1,1);
INSERT INTO student_course(student_id, course_id) VALUES (2,1);
INSERT INTO student_course(student_id, course_id) VALUES (3,1);
INSERT INTO student_course(student_id, course_id) VALUES (2,2);
INSERT INTO student_course(student_id, course_id) VALUES (3,3);
INSERT INTO student_course(student_id, course_id) VALUES (1,2);
