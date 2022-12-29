package com.digitalaicloud.hibernate.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class Course {

    @Id // PRIMARY KEY
    // HIBERNATE USES SEQUENCE, FIRST IT CALL SEQUENCE TO GET NEXT SEQUENCE & THEN IT INSERT
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
    private Long id; // COLUMN

    //@Setter(value=AccessLevel.NONE) // WE CAN'T SET/CHANGE COURSE
    private String name; // COLUMN

}
