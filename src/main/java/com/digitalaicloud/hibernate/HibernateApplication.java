package com.digitalaicloud.hibernate;

import com.digitalaicloud.hibernate.repository.CourseRepository;
import com.digitalaicloud.hibernate.repository.CourseRepositoryDemo;
import com.digitalaicloud.hibernate.repository.ReviewRepository;
import com.digitalaicloud.hibernate.services.CourseService;
import com.digitalaicloud.hibernate.services.PassportService;
import com.digitalaicloud.hibernate.services.ReviewService;
import com.digitalaicloud.hibernate.services.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;


@Slf4j
@SpringBootApplication
public class HibernateApplication implements CommandLineRunner {
	private final ReviewRepository reviewRepository;
	private final CourseRepository courseRepository;
	private final CourseRepositoryDemo courseRepositoryDemo;

	private final StudentService studentService;
	private final PassportService passportService;
	private final ReviewService reviewService;
	private final CourseService courseService;


	public HibernateApplication(CourseRepositoryDemo courseRepositoryDemo, StudentService studentService, PassportService passportService,
								CourseRepository courseRepository,
								ReviewRepository reviewRepository, ReviewService reviewService, CourseService courseService) {
		this.courseRepositoryDemo = courseRepositoryDemo;
		this.studentService = studentService;
		this.passportService = passportService;
		this.courseRepository = courseRepository;
		this.reviewRepository = reviewRepository;
		this.reviewService = reviewService;
		this.courseService = courseService;
	}

	public static void main(String[] args) {
		SpringApplication.run(HibernateApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) {

//		Course azure = Course.builder().name("AZURE").price(499.00).build();
//		Course aws = Course.builder().name("AWS").price(499.00).build();
//		courseRepository.saveOrUpdate(azure);
//		courseRepository.saveOrUpdate(aws);


//		log.info("Adding new Course -> {}", courseRepository.saveOrUpdate(Course.builder().name("AWS").build()));
//		Course byId = courseRepository.findById(1L);
//		log.info("Course with id 1L -> {} ", byId);
//
//		byId.setName("AWS CLOUD");
//		log.info("Update AWS to AWS Cloud -> {}", courseRepository.saveOrUpdate(byId));

//		log.info("Delete Course with is 1 ");
//		courseRepositoryDemo.deleteById(1L);

//		courseRepositoryDemo.playWithEntityManager();

//		courseRepositoryDemo.playWithEntityManagerInsertFalse();
//		courseRepositoryDemo.playWithEntityManagerUpdateFalse();

//		courseRepositoryDemo.jpqlQuery();
//		courseRepositoryDemo.jpqlTypedQuery();
//		courseRepositoryDemo.jpqlNamedQuery();
//		courseRepositoryDemo.jpqlNativeQuery();
//		courseRepositoryDemo.jpqlNativeQueryNamedParam();
//		courseRepositoryDemo.jpqlNativeQueryUpdate();


		/**
		 *
		 * ONE TO ONE
		 *
		 * Student is the owning side
		 * So we need to save the Passport first then Student
		 * If we don't save Passport we will get error TransientPropertyValueException - object references an unsaved transient instance - save the transient instance before flushing
		 * That means save Passport first to db then Student
		 *
		 * Or
		 *
		 * We can use cascade = CascadeType.ALL in Student Class for Passport
		 *
		 * When we call .save(object) then it call hibernate_sequence and get id from db
		 * At end of method it will take complete object along with id from db and save it to db
		 *
		 *
		 */
//		Passport passport = Passport.builder()
//				.number("N7253")
//				.build();
//		// We can comment this if we use
//		// cascade = CascadeType.ALL in Student Class for Passport
//		passportService.save(passport);
//
//		Student student = Student.builder()
//				.name("Kuldeep Baswan")
//				.passport(passport)
//				.build();
//		studentService.save(student);


		/**
		 * ONE TO ONE
		 *
		 * Read from db
		 *
		 * When we call findById(1L) we create a new transaction and fetch student in lazy fashion
		 * After that we print student
		 * After that we call student.getPassport() which will going to throw the error LazyInitializationException: could not initialize proxy [com.digitalaicloud.hibernate.entity.Passport#1] - no Session
		 * We get this error because the transaction is already closed when we get response for findById(1L)
		 * To fix this we wrap this run() with @Transactional
		 * Or we need to call student.getPassport() in same transaction
		 */
//		Student student = studentService.findById(1L);
//		log.info(student.toString());
//		log.info(student.getPassport().toString());

		/**
		 * ONE TO ONE BIDIRECTIONAL
		 * fetching student using passport
		 */
//		Passport byId = passportService.findById(1L);
//		log.info(byId.toString());
//		log.info(byId.getStudent().toString());

		/**
		 * ONE TO MANY    AND    MANY TO ONE
		 * Save Reviews for a Course
		 */
//		// fetch course
//		Optional<Course> byId = courseRepository.findById(1l);
//		Course course = byId.get();
//		log.info(course.toString());
//		log.info(course.getReviews().toString());
//
//		// create reviews or get from ui
//		Review review1 = Review.builder().rating("5").description("Wonderful Course").course(course).build();
//		Review review2 = Review.builder().rating("5").description("Love this Course").course(course).build();
//
//		// set reviews on course using convenient method we created
//		byId.get().addReview(review1);
//		byId.get().addReview(review2);
//
//		// review is the owning side of the relationship, we need to tell which course to it
//		review1.setCourse(course);
//		review2.setCourse(course);
//
//		// save to db, we are not doing anything on course so we will only persist reviews
//		reviewService.save(review1);
//		reviewService.save(review2);

		/**
		 * Fetching Course which has @OneToMany
		 * It will fetch in Lazy fashion as @OneToMany is Lazy by default
		 * Only when we call getReviews on Course then only it will fetch reviews
		 *
		 * Fetching Reviews which has @ManyToOne
		 * It will fetch in Eager fashion as @ManyToOne is Eager by default
		 * That means it will fetch Course with Reviews
		 */


		/**
		 * Many To Many Fetch
		 */
//		Course course = courseService.findById(1L);
//		log.info(course.toString());
//		log.info(course.getStudents().toString());

//		Student student = studentService.findById(1L);
//		log.info(student.toString());
//		log.info(student.getCourses().toString());


		/**
		 * Many To Many Insert
		 */
//		Student student = Student.builder().name("Kuldeep Baswan").build();
//		studentService.save(student);
//
//		Course course = Course.builder().name("Microservices").build();
//		courseService.save(course);
//
//		// create relationship
//		course.addStudent(student);
//		student.addCourse(course);
//
//		// save the owning side
//		studentService.save(student);


		/**
		 * Use Hibernate Relation in JPQL
		 */
//		courseRepositoryDemo.jpqlCoursesWithoutStudent();
//		courseRepositoryDemo.jpqlCoursesWithAtLeastTwoStudent();
//		courseRepositoryDemo.jpqlCoursesOrderByStudentSize();
//		courseRepositoryDemo.jpqlStudentsWithPassportInACertainPattern();
//		courseRepositoryDemo.jpqlJoin();
//		courseRepositoryDemo.jpqlLeftJoin();
		courseRepositoryDemo.jpqlCrossJoin();

	}


}
