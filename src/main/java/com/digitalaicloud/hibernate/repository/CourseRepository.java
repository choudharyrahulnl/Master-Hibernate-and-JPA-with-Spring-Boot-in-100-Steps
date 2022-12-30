package com.digitalaicloud.hibernate.repository;

import com.digitalaicloud.hibernate.entity.Course;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import java.util.List;

@Repository
@Transactional // IF WE CHANGE DATA WE NEED @TRANSACTIONAL EX INSERT/UPDATE/DELETE
@Slf4j
public class CourseRepository {

    private EntityManager entityManager;

    public CourseRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Course findById(Long id) {
        return entityManager.find(Course.class, id);
    }

    public Course saveOrUpdate(Course course) {
        if (course.getId() == null) {
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

        Course azure = Course.builder().name("AZURE").build();
        entityManager.persist(azure);

        // We can forcefully call flush to make the db call
        entityManager.flush();

        // EntityManager is keeping track of object azure, when we update azure object using setter
        // EntityManager will do dirty checking and find difference and make db call to update
        azure.setName("Azure-Updated");


        Course aws = Course.builder().name("AWS").build();
        entityManager.persist(aws);

        aws.setName("AWS-Updated");

        // We can detach a persistent object after which entity manager will no longer track this
        // and if we change aws object these changes will not be push to db
        //entityManager.detach(aws);

        // We can also call clear to remove everything from entity manager
        // entityManager.clear();

        // refresh from db, this will reset aws object from db that means aws.setName("AWS-Updated") aws object
        // is lost now and entity manager not found any change so no db call
        entityManager.refresh(aws);
    }

    public void playWithEntityManagerUpdateFalse() {

        Course azure = Course.builder().name("AZURE").price(395.00).build();
        entityManager.persist(azure);

        azure.setName("Azure-Updated!!");
        azure.setPrice(499.00);
    }

    public void playWithEntityManagerInsertFalse() {

        Course azure = Course.builder().name("AZURE").price(395.00).build();
        entityManager.persist(azure);

        azure.setName("Azure-Updated!!");
    }

    public void jpqlQuery() {
        Query query = entityManager.createQuery("FROM Course c");
        List resultList = query.getResultList();
        log.info(resultList.toString());
    }

    public void jpqlTypedQuery() {
        TypedQuery<Course> query = entityManager.createQuery("FROM Course c", Course.class);
        List<Course> resultList = query.getResultList();
        log.info(resultList.toString());
    }

    public void jpqlNamedQuery() {
        TypedQuery<Course> query = entityManager.createNamedQuery("query_get_all_courses", Course.class);
        List<Course> resultList = query.getResultList();
        log.info(resultList.toString());
    }
}
