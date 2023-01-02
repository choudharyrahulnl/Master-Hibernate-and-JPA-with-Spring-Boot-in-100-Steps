package com.digitalaicloud.hibernate.services;

import com.digitalaicloud.hibernate.entity.Course;

import java.util.List;

public interface CourseService {
    Course findById(Long id);

    Course save(Course course);

    List<Course> findAll();

    void deleteById(Long id);
}
