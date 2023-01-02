package com.digitalaicloud.hibernate.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

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
@EqualsAndHashCode(of = {"id"})
// NAMED QUERIES
//@NamedQueries(value = {
//        @NamedQuery(name = "query_get_all_courses", query = "SELECT c FROM Course c"),
//})
//@Cacheable
// FOR ALL NATIVE QUERIES WE NEED TO UPDATE QUERY MANUALLY
@SQLDelete(sql = "update course set is_deleted=true where id=?")
@Where(clause = "is_deleted = false")
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

//    @CreationTimestamp
//    private Instant createdDate;
//    @UpdateTimestamp
//    private Instant updatedDate;

    @Column(name = "is_deleted")
    private boolean isDeleted;

    @PreRemove
    private void preRemove() {
        this.isDeleted = true;
    }

    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Review> reviews;

    @ManyToMany(mappedBy = "courses", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Student> students;

    public void addReview(Review review) {
        reviews.add(review);
    }

    public void removeReview(Review review) {
        reviews.remove(review);
    }

    public void addStudent(Student student) {
        if(this.students == null) {
            this.students = new ArrayList<>();
        }
        this.students.add(student);
    }

    public void removeStudent(Student student) {
        this.students.add(student);
    }
}
