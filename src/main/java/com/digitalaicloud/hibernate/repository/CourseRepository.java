package com.digitalaicloud.hibernate.repository;

import com.digitalaicloud.hibernate.entity.Course;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@Transactional // IF WE CHANGE DATA WE NEED @TRANSACTIONAL EX INSERT/UPDATE/DELETE
public class CourseRepository {

    private EntityManager entityManager;

    public CourseRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Course findById(Long id) {
        return entityManager.find(Course.class, id);
    }

    public Course saveOrUpdate(Course course) {
        if(course.getId() == null) {
            entityManager.persist(course);
        } else {
            entityManager.merge(course);
        }
        return course;
    }

    public void deleteById(Long id) {
        Course course = findById(id);
        entityManager.remove(course);
    }

    public void playWithEntityManager() {
        Course course = Course.builder().name("AZURE").build();
        entityManager.persist(course);

        course.setName("Azure");
    }
}
