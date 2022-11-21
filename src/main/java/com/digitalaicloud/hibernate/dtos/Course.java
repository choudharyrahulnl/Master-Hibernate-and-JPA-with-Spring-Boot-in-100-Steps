package com.digitalaicloud.hibernate.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class Course {

    private long id;
    private String name;
    private String author;
}
