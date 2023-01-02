package com.digitalaicloud.hibernate.apis;

import com.digitalaicloud.hibernate.entity.Course;
import com.digitalaicloud.hibernate.services.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/courses")
@Slf4j
public class CourseApi {

    private final CourseService courseService;

    public CourseApi(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> findById(@PathVariable Long id) {
        Course byId = courseService.findById(id);
        log.info(byId.toString());
        return new ResponseEntity<>(byId, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        courseService.deleteById(id);
        return new ResponseEntity<>("Successfully", HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<Course>> findAll() {
        return new ResponseEntity<>(courseService.findAll(), HttpStatus.OK);
    }
}
