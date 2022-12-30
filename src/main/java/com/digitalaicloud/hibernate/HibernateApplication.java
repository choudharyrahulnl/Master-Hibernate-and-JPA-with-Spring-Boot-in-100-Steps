package com.digitalaicloud.hibernate;

import com.digitalaicloud.hibernate.entity.Passport;
import com.digitalaicloud.hibernate.entity.Student;
import com.digitalaicloud.hibernate.repository.CourseRepositoryDemo;
import com.digitalaicloud.hibernate.services.PassportService;
import com.digitalaicloud.hibernate.services.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;


@Slf4j
@SpringBootApplication
public class HibernateApplication implements CommandLineRunner {

	private final CourseRepositoryDemo courseRepositoryDemo;
	private final StudentService studentService;
	private final PassportService passportService;


	public HibernateApplication(CourseRepositoryDemo courseRepositoryDemo, StudentService studentService, PassportService passportService) {
		this.courseRepositoryDemo = courseRepositoryDemo;
		this.studentService = studentService;
		this.passportService = passportService;
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
//		courseRepository.deleteById(1L);

//		courseRepository.playWithEntityManager();

//		courseRepository.playWithEntityManagerInsertFalse();
//		courseRepository.playWithEntityManagerUpdateFalse();

//		courseRepository.jpqlQuery();
//		courseRepository.jpqlTypedQuery();
//		courseRepository.jpqlNamedQuery();
//		courseRepository.jpqlNativeQuery();
//		courseRepository.jpqlNativeQueryNamedParam();
//		courseRepository.jpqlNativeQueryUpdate();


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




	}


}
