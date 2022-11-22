package com.digitalaicloud.hibernate.repository;

import com.digitalaicloud.hibernate.entity.Person;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

@Repository
public class PersonJdbcDao {

    private JdbcTemplate jdbcTemplate;

    public PersonJdbcDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // SELECT * FROM person
    public List<Person> findAll() {
        return jdbcTemplate.query("SELECT * FROM PERSON", new BeanPropertyRowMapper<>(Person.class));
    }

    // SELECT * FROM person WHERE person_id=?
    public Person findById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM person WHERE person_id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Person.class));
    }

    // DELETE FROM person WHERE person_id=?
    public Integer deleteById(int id) {
        return jdbcTemplate.update("DELETE FROM person WHERE person_id=?", new Object[]{id});
    }

    // INSERT INTO person (person_id, person_name, person_location, person_birth_date)
    //VALUES (10001,'Rahul','Rotterdam',CURRENT_TIMESTAMP());
    public Integer insert(Person person) {
        return jdbcTemplate.update("INSERT INTO person (person_id, person_name, person_location, person_birth_date) " +
                "VALUES (?,?,?,?)", new Object[]{person.getPersonId(), person.getPersonName(), person.getPersonLocation(), new Timestamp(person.getPersonBirthDate().getTime())});
    }

    // UPDATE person SET person_name = ?, person_location = ?, person_birth_date = ? WHERE person_id = ?
    public Integer update(Person person) {
        return jdbcTemplate.update("UPDATE person SET person_name = ?, person_location = ?, person_birth_date = ? WHERE person_id = ?", new Object[]{person.getPersonName(), person.getPersonLocation(), new Timestamp(person.getPersonBirthDate().getTime()), person.getPersonId()});
    }

    class PersonRowMapper implements RowMapper<Person> {
        @Override
        public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
            return Person.builder()
                    .personId(rs.getInt("person_id"))
                    .personName(rs.getString("person_name"))
                    .personLocation(rs.getString("person_location"))
                    .personBirthDate(rs.getTimestamp("person_birth_date"))
                    .build();
        }
    }

//     NOW WE CAN USE PersonRowMapper INSTEAD OF SPRING - BeanPropertyRowMapper
//     WE CAN USE THIS IF COLUMN NAME ARE NOT SAME IN JAVA & SQL
//    public List<Person> findAll() {
//        return jdbcTemplate.query("SELECT * FROM PERSON", new PersonRowMapper());
//    }


}
