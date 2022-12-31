package com.digitalaicloud.hibernate.services.impl;

import com.digitalaicloud.hibernate.entity.Course;
import com.digitalaicloud.hibernate.exceptions.NotFoundException;
import com.digitalaicloud.hibernate.repository.CourseRepository;
import com.digitalaicloud.hibernate.services.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@Slf4j
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Course findById(Long id) {
        Optional<Course> byId = courseRepository.findById(id);
        if(!byId.isPresent()) {
            throw new NotFoundException("Course not found for id " + id);
        }
        return byId.get();
    }

    @Override
    public Course save(Course course) {
        return courseRepository.save(course);
    }
}
