package com.digitalaicloud.hibernate;

import com.digitalaicloud.hibernate.repository.CourseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@Slf4j
@SpringBootApplication
public class HibernateApplication implements CommandLineRunner {

	private final CourseRepository courseRepository;

	public HibernateApplication(CourseRepository courseRepository) {
		this.courseRepository = courseRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(HibernateApplication.class, args);
	}

	@Override
	public void run(String... args) {
//		log.info("Adding new Course -> {}", courseRepository.saveOrUpdate(Course.builder().name("AWS").build()));
//		Course byId = courseRepository.findById(1L);
//		log.info("Course with id 1L -> {} ", byId);
//
//		byId.setName("AWS CLOUD");
//		log.info("Update AWS to AWS Cloud -> {}", courseRepository.saveOrUpdate(byId));

//		log.info("Delete Course with is 1 ");
//		courseRepository.deleteById(1L);

//		courseRepository.playWithEntityManager();

//		courseRepository.playWithEntityManagerUpdateFalse();
//		courseRepository.playWithEntityManagerInsertFalse();
	}


}
