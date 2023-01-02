package com.digitalaicloud.hibernate.repository;

import com.digitalaicloud.hibernate.entity.Course;
import com.digitalaicloud.hibernate.entity.Student;
import com.digitalaicloud.hibernate.exceptions.NotFoundException;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Repository
@Transactional(isolation = Isolation.REPEATABLE_READ) // IF WE CHANGE DATA WE NEED @TRANSACTIONAL EX INSERT/UPDATE/DELETE
@Slf4j
public class CourseRepositoryDemo {

    private EntityManager entityManager;
    private CourseRepository courseRepository;

    public CourseRepositoryDemo(EntityManager entityManager, CourseRepository courseRepository) {
        this.entityManager = entityManager;
        this.courseRepository = courseRepository;
    }

    public Course findById(Long id) {
        return entityManager.find(Course.class, id);
    }

//    public Course saveOrUpdate(Course course) {
//        if (course.getId() == null) {
//            entityManager.persist(course);
//        } else {
//            entityManager.merge(course);
//        }
//        return course;
//    }
//
//    public void deleteById(Long id) {
//        Course course = findById(id);
//        entityManager.remove(course);
//    }

//    public void playWithEntityManager() {
//
//        Course azure = Course.builder().name("AZURE").build();
//        entityManager.persist(azure);
//
//        // We can forcefully call flush to make the db call
//        entityManager.flush();
//
//        // EntityManager is keeping track of object azure, when we update azure object using setter
//        // EntityManager will do dirty checking and find difference and make db call to update
//        azure.setName("Azure-Updated");
//
//
//        Course aws = Course.builder().name("AWS").build();
//        entityManager.persist(aws);
//
//        aws.setName("AWS-Updated");
//
//        // We can detach a persistent object after which entity manager will no longer track this
//        // and if we change aws object these changes will not be push to db
//        //entityManager.detach(aws);
//
//        // We can also call clear to remove everything from entity manager
//        // entityManager.clear();
//
//        // refresh from db, this will reset aws object from db that means aws.setName("AWS-Updated") aws object
//        // is lost now and entity manager not found any change so no db call
//        entityManager.refresh(aws);
//    }

//    public void playWithEntityManagerUpdateFalse() {
//
//        Course azure = Course.builder().name("AZURE").price(395.00).build();
//        entityManager.persist(azure);
//
//        azure.setName("Azure-Updated!!");
//        azure.setPrice(499.00);
//    }
//
//    public void playWithEntityManagerInsertFalse() {
//
//        Course azure = Course.builder().name("AZURE").price(395.00).build();
//        entityManager.persist(azure);
//
//        azure.setName("Azure-Updated!!");
//    }
//
//    public void jpqlQuery() {
//        Query query = entityManager.createQuery("FROM Course c");
//        List resultList = query.getResultList();
//        log.info(resultList.toString());
//    }
//
//    public void jpqlTypedQuery() {
//        TypedQuery<Course> query = entityManager.createQuery("FROM Course c", Course.class);
//        List<Course> resultList = query.getResultList();
//        log.info(resultList.toString());
//    }
//
//    public void jpqlNamedQuery() {
//        TypedQuery<Course> query = entityManager.createNamedQuery("query_get_all_courses", Course.class);
//        List<Course> resultList = query.getResultList();
//        log.info(resultList.toString());
//    }
//
//    public void jpqlNativeQuery() {
//        Query query = entityManager.createNativeQuery("SELECT * FROM course c WHERE c.price = ?", Course.class);
//        query.setParameter(1, 499.00);
//        List<Course> resultList = query.getResultList();
//        log.info(resultList.toString());
//    }
//
//    public void jpqlNativeQueryNamedParam() {
//        Query query = entityManager.createNativeQuery("SELECT * FROM course c WHERE c.price = :price", Course.class);
//        query.setParameter("price", 499.00);
//        List<Course> resultList = query.getResultList();
//        log.info(resultList.toString());
//    }
//
//    public void jpqlNativeQueryUpdate() {
//        Query query = entityManager.createNativeQuery("UPDATE course SET updated_date = sysdate()", Course.class);
//        int noOfRowsUpdated = query.executeUpdate();
//        log.info(String.valueOf(noOfRowsUpdated));
//    }

    public void jpqlCoursesWithoutStudent() {
        Query query = entityManager.createQuery("select c from Course c where c.students is empty", Course.class);
        List<Course> resultList = query.getResultList();
        log.info(resultList.toString());
    }


    public void jpqlCoursesWithAtLeastTwoStudent() {
        TypedQuery<Course> query = entityManager.createQuery("select c from Course c where size(c.students) >= 2", Course.class);
        List<Course> resultList = query.getResultList();
        log.info(resultList.toString());
    }

    public void jpqlCoursesOrderByStudentSize() {
        TypedQuery<Course> query = entityManager.createQuery("select c from Course c order by size(c.students) desc", Course.class);
        List<Course> resultList = query.getResultList();
        log.info(resultList.toString());
    }

    public void jpqlStudentsWithPassportInACertainPattern() {
        TypedQuery<Student> query = entityManager.createQuery("select s from Student s where s.passport.number like '%42%'", Student.class);
        List<Student> resultList = query.getResultList();
        log.info(resultList.toString());
    }

    public void jpqlJoin() {
        Query query = entityManager.createQuery("select c,s from Course c JOIN c.students s");
        List<Object[]> resultList = query.getResultList();
        for (Object[] result: resultList) {
            log.info("Course {} Student {}",result[0], result[1]);
        }
    }

    public void jpqlLeftJoin() {
        Query query = entityManager.createQuery("select c,s from Course c LEFT JOIN c.students s");
        List<Object[]> resultList = query.getResultList();
        for (Object[] result: resultList) {
            log.info("Course {} Student {}",result[0], result[1]);
        }
    }

    public void jpqlCrossJoin() {
        Query query = entityManager.createQuery("select c,s from Course c, Student s");
        List<Object[]> resultList = query.getResultList();
        for (Object[] result: resultList) {
            log.info("Course {} Student {}",result[0], result[1]);
        }
    }

    public void criteriaQuerySelectFromCourse() {

        // 1. Use Criteria Builder to create a Criteria Query returning the expected result object
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Course> criteriaQuery = criteriaBuilder.createQuery(Course.class);

        // 2. Define roots for tables which are involved in the query
        Root<Course> courseRoot = criteriaQuery.from(Course.class);

        // 3. Define Predicates etc. using Criteria Builder

        // 4. Add Predicates etc. to the Criteria Query

        // 5. Build TypedQuery with entity manager & criteria query
        TypedQuery<Course> query = entityManager.createQuery(criteriaQuery.select(courseRoot));
        List<Course> resultList = query.getResultList();
        log.info(resultList.toString());
    }

    public void criteriaQueryCourseNameLike() {
        // 1. Use Criteria Builder to create a Criteria Query returning the expected result object
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Course> criteriaQuery = criteriaBuilder.createQuery(Course.class);

        // 2. Define roots for tables which are involved in the query
        Root<Course> courseRoot = criteriaQuery.from(Course.class);

        // 3. Define Predicates etc. using Criteria Builder
        Predicate nameLike = criteriaBuilder.like(courseRoot.get("name"), "%Cloud%");

        // 4. Add Predicates etc. to the Criteria Query
        criteriaQuery.where(nameLike);

        // 5. Build TypedQuery with entity manager & criteria query
        TypedQuery<Course> query = entityManager.createQuery(criteriaQuery.select(courseRoot));
        List<Course> resultList = query.getResultList();
        log.info(resultList.toString());
    }

    public void criteriaQueryCoursesWithoutStudent() {
        // 1. Use Criteria Builder to create a Criteria Query returning the expected result object
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Course> criteriaQuery = criteriaBuilder.createQuery(Course.class);

        // 2. Define roots for tables which are involved in the query
        Root<Course> courseRoot = criteriaQuery.from(Course.class);

        // 3. Define Predicates etc. using Criteria Builder
        Predicate studentsIsEmpty = criteriaBuilder.isEmpty(courseRoot.get("students"));

        // 4. Add Predicates etc. to the Criteria Query
        criteriaQuery.where(studentsIsEmpty);

        // 5. Build TypedQuery with entity manager & criteria query
        TypedQuery<Course> query = entityManager.createQuery(criteriaQuery.select(courseRoot));
        List<Course> resultList = query.getResultList();
        log.info(resultList.toString());
    }

    public void criteriaQueryCourseAndStudentJoin() {
        // 1. Use Criteria Builder to create a Criteria Query returning the expected result object
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Course> criteriaQuery = criteriaBuilder.createQuery(Course.class);

        // 2. Define roots for tables which are involved in the query
        Root<Course> courseRoot = criteriaQuery.from(Course.class);

        // 3. Define Predicates etc. using Criteria Builder
        Join<Object, Object> students = courseRoot.join("students");

        // 4. Add Predicates etc. to the Criteria Query

        // 5. Build TypedQuery with entity manager & criteria query
        TypedQuery<Course> query = entityManager.createQuery(criteriaQuery.select(courseRoot));
        List<Course> resultList = query.getResultList();
        log.info(resultList.toString());
    }

    public void criteriaQueryCourseAndStudentLeftJoin() {
        // 1. Use Criteria Builder to create a Criteria Query returning the expected result object
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Course> criteriaQuery = criteriaBuilder.createQuery(Course.class);

        // 2. Define roots for tables which are involved in the query
        Root<Course> courseRoot = criteriaQuery.from(Course.class);

        // 3. Define Predicates etc. using Criteria Builder
        Join<Object, Object> students = courseRoot.join("students", JoinType.LEFT);

        // 4. Add Predicates etc. to the Criteria Query

        // 5. Build TypedQuery with entity manager & criteria query
        TypedQuery<Course> query = entityManager.createQuery(criteriaQuery.select(courseRoot));
        List<Course> resultList = query.getResultList();
        log.info(resultList.toString());
    }

    public void jpaSortDesc() {
        Sort sort = Sort.by(Sort.Direction.DESC, "name");
        List<Course> resultList = courseRepository.findAll(sort);
        log.info(resultList.toString());
    }

    public void jpaSortsDesc() {
        Sort sort = Sort.by(Sort.Direction.DESC, "name").and(Sort.by(Sort.Direction.DESC, "createdDate"));
        List<Course> resultList = courseRepository.findAll(sort);
        log.info(resultList.toString());
    }

    public void jpaPagination() {
        PageRequest pageRequest = PageRequest.of(0,2);
        Page<Course> resultList = courseRepository.findAll(pageRequest);
        log.info(resultList.getContent().toString());
    }

    public void jpaQuerySearchByName() {
        Course azure = courseRepository.findByName("Azure Cloud").orElseThrow(() -> new NotFoundException("Course not found with name Azure"));
        log.info(azure.toString());
    }

    public void jpaNamedQuery() {
        List<Course> allCourse = courseRepository.findAllCourse();
        log.info(allCourse.toString());
    }
}

