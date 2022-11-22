package com.digitalaicloud.hibernate;

import com.digitalaicloud.hibernate.entity.Person;
import com.digitalaicloud.hibernate.repository.PersonJdbcDao;
import com.digitalaicloud.hibernate.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@Slf4j
@SpringBootApplication
public class HibernateApplication implements CommandLineRunner {

	private PersonJdbcDao personJdbcDao;
	private PersonRepository personRepository;

	public HibernateApplication(PersonJdbcDao personJdbcDao, PersonRepository personRepository) {
		this.personJdbcDao = personJdbcDao;
		this.personRepository = personRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(HibernateApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// SPRING JDBC
//		log.info("All Users -> {}", personJdbcDao.findAll());
//		log.info("Users id 10001 -> {}", personJdbcDao.findById(10001));
//		log.info("Delete Users id 10002 number of rows deleted -> {}", personJdbcDao.deleteById(10002));
//		log.info("Insert new User id 10004 -> {}", personJdbcDao.insert(Person.builder().personId(10004).personName("John-Insert").personLocation("Blaak").personBirthDate(new Date()).build()));
//		log.info("Update User id 10003 -> {}", personJdbcDao.update(Person.builder().personId(10003).personName("Peter-Update").personLocation("Utrecht").personBirthDate(new Date()).build()));



		// SPRING JPA
//		log.info("Users id 1 -> {}", personRepository.findById(1));
//		log.info("Insert new User -> {}", personRepository.insertOrUpdate(Person.builder().personName("John").personLocation("Blaak").personBirthDate(new Date()).build()));
//		log.info("Update User id 3 -> {}", personRepository.insertOrUpdate(Person.builder().personId(3).personName("Peter-Update").personLocation("Utrecht").personBirthDate(new Date()).build()));
//		log.info("Delete Users id 2");
//		personRepository.deleteById(2);
//		log.info("All Users -> {}", personRepository.findAll());

	}


}
