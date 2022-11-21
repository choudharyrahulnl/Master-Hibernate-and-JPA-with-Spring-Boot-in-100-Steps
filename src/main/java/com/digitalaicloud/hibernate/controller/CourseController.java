package com.digitalaicloud.hibernate.controller;

import com.digitalaicloud.hibernate.dtos.Course;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @GetMapping
    public List<Course> getAllCourses() {
        return Arrays.asList(
                Course.builder().id(1).name("Learn Spring").author("Spring Documentation").build(),
                Course.builder().id(2).name("AWS").author("AWS Documentation").build()
        );
    }
}
