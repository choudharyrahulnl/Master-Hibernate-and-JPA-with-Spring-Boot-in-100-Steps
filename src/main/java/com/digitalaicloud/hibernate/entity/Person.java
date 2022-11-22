package com.digitalaicloud.hibernate.entity;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Person {

    private int personId;
    private String personName;
    private String personLocation;
    private Date personBirthDate;
}
