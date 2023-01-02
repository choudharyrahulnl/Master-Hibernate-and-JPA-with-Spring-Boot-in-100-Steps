package com.digitalaicloud.hibernate.repository;

import com.digitalaicloud.hibernate.HibernateApplication;
import com.digitalaicloud.hibernate.entity.Course;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = HibernateApplication.class)
@Slf4j
class CourseRepositoryTest {

    @Autowired
    CourseRepository repository;

    @Test
    @DirtiesContext
    public void findById_firstLevelCacheDemo() {

        Optional<Course> course = repository.findById(1L);
        log.info("First Course Retrieved {}", course.get());

        Optional<Course> course1 = repository.findById(2L);
        log.info("First Course Retrieved again {}", course1.get());

        assertEquals("AWS Cloud", course.get().getName());

        assertEquals("Spring Boot", course1.get().getName());
    }

    @Test
    @DirtiesContext
    public void deleteById_basic() {
        repository.deleteById(4L);
        assertThrows(NoSuchElementException.class ,() -> repository.findById(4L).get());
    }

}