package com.digitalaicloud.hibernate.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "review")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString(of = {"id","description"})
@EqualsAndHashCode(of = {"id"})
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "description")
    private String description;
}
