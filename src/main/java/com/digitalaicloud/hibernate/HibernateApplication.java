package com.digitalaicloud.hibernate;

import com.digitalaicloud.hibernate.entity.Person;
import com.digitalaicloud.hibernate.repository.PersonJdbcDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@Slf4j
@SpringBootApplication
public class HibernateApplication implements CommandLineRunner {

	private PersonJdbcDao personJdbcDao;

	public HibernateApplication(PersonJdbcDao personJdbcDao) {
		this.personJdbcDao = personJdbcDao;
	}

	public static void main(String[] args) {
		SpringApplication.run(HibernateApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("All Users -> {}", personJdbcDao.findAll());
		log.info("Users id 10001 -> {}", personJdbcDao.findById(10001));
		log.info("Delete Users id 10002 number of rows deleted -> {}", personJdbcDao.deleteById(10002));
		log.info("Insert new User id 10004 -> {}", personJdbcDao.insert(Person.builder().personId(10004).personName("John-Insert").personLocation("Blaak").personBirthDate(new Date()).build()));
		log.info("Update User id 10003 -> {}", personJdbcDao.update(Person.builder().personId(10003).personName("Peter-Update").personLocation("Utrecht").personBirthDate(new Date()).build()));
	}


}
