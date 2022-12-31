package com.digitalaicloud.hibernate.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "passport")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString(of = {"id","number"})
@EqualsAndHashCode(of = {"id"})
public class Passport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "number", nullable = false, unique = true)
    private String number;

    /**
     * Mapped By:
     * In Student Class we have @OneToOne which will create passport_id column in Student Table
     * If we don't use mapped by in Passport Class then in Passport Table we will have student_id column
     * This is duplication of data
     * Student Table -> student_id & passport_id
     * Passport Table -> passport_id & student_id
     *
     * So we need to use mapped by which says don't create new column in Passport Table
     * instead refer to the reference table ie Student Table and column passport ie passport_id column
     *
     * mapped by will not come in owing side of relationship, it will be used in non-owning side
     */
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "passport")
    private Student student;
}
