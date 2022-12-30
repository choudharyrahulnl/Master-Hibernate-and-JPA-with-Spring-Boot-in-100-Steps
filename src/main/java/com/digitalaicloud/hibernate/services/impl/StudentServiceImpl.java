package com.digitalaicloud.hibernate.services.impl;

import com.digitalaicloud.hibernate.entity.Student;
import com.digitalaicloud.hibernate.exceptions.NotFoundException;
import com.digitalaicloud.hibernate.repository.StudentRepository;
import com.digitalaicloud.hibernate.services.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@Slf4j
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student findById(Long id) {
        Optional<Student> byId = studentRepository.findById(id);
        if(!byId.isPresent()) {
            throw new NotFoundException("Student not found with id " + id);
        }
        return byId.get();
    }
}
