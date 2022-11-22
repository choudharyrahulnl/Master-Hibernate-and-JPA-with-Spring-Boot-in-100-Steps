package com.digitalaicloud.hibernate.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "person")
@NamedQuery(name="find_all_person", query = "select p from Person p")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private int personId;

    @Column(name = "person_name")
    private String personName;

    @Column(name = "person_location")
    private String personLocation;

    @Column(name = "person_birth_date")
    private Date personBirthDate;
}
