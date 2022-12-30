package com.digitalaicloud.hibernate.entity;

import lombok.*;

import javax.persistence.*;

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

    // @Setter(value=AccessLevel.NONE) // WE CAN'T SET/CHANGE COURSE
    // updatable = false: If we try to update this variable it won't work
    // if we try to update this along with other variable like price then only price will update
    @Column(name = "name", nullable = false, unique = true, updatable = false)
    private String name; // COLUMN

    // insertable = false when we insert new row this filed will not be inserted it will be null
    // updatable = true by default so on update this field will get its value
    @Column(name = "price", insertable = false)
    private Double price;

}
