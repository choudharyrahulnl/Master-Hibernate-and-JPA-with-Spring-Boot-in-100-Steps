package com.digitalaicloud.hibernate.entity;

import lombok.*;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "course")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
//@ToString(of = {"id","name", "price"})
@ToString(of = {"id","name"})
@EqualsAndHashCode(of = {"id"})
// NAMED QUERIES
//@NamedQueries(value = {
//        @NamedQuery(name = "query_get_all_courses", query = "SELECT c FROM Course c"),
//})

public class Course {

    // @Id // PRIMARY KEY
    // HIBERNATE USES SEQUENCE, FIRST IT CALL SEQUENCE TO GET NEXT SEQUENCE & THEN IT INSERT
    // @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
    // private Long id; // COLUMN

    // @Setter(value=AccessLevel.NONE) // WE CAN'T SET/CHANGE COURSE
    // updatable = false: If we try to update this variable it won't work
    // if we try to update this along with other variable like price then only price will update
    // @Column(name = "name", nullable = false, unique = true, updatable = false)
    // private String name;

    // insertable = false when we insert new row this filed will not be inserted it will be null
    // updatable = true by default so on update this field will get its value
    // @Column(name = "price", insertable = false)
    // @Column(name = "price")
    // private Double price;



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @CreationTimestamp
    private Instant createdDate;
    @UpdateTimestamp
    private Instant updatedDate;

    @OneToMany(mappedBy = "course")
    private List<Review> reviews = new ArrayList<>();

    public void addReview(Review review) {
        reviews.add(review);
    }

    public void removeReview(Review review) {
        reviews.remove(review);
    }
}
