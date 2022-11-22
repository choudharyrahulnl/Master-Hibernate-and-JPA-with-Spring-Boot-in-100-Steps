package com.digitalaicloud.hibernate.repository;

import com.digitalaicloud.hibernate.entity.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
@Slf4j
public class PersonRepository {

    @PersistenceContext
    EntityManager entityManager;

    public Person findById(int id) {
        return entityManager.find(Person.class, id);
    }

    public List<Person> findAll() {
        TypedQuery<Person> findAllPerson = entityManager.createNamedQuery("find_all_person", Person.class);
        return findAllPerson.getResultList();
    }

    // MERGE WILL CHECK WEATHER WE PASS ID OR NOT BASED ON THAT IT WILL CALL INSERT/UPDATE
    public Person insertOrUpdate(Person person) {
        return entityManager.merge(person);
    }

    public void deleteById(int id) {
        Person person = findById(id);
        entityManager.remove(person);
    }


}
