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
}
