package com.digitalaicloud.hibernate.repository;

import com.digitalaicloud.hibernate.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {

    Optional<Course> findByName(String name);

    @Query(name = "query_get_all_courses")
    List<Course> findAllCourse();
}
