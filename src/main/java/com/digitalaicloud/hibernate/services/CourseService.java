package com.digitalaicloud.hibernate.services;

import com.digitalaicloud.hibernate.entity.Course;

public interface CourseService {
    Course findById(Long id);

    Course save(Course course);
}
