package com.digitalaicloud.hibernate.services;

import com.digitalaicloud.hibernate.entity.Student;

public interface StudentService {

    Student save(Student student);
    Student findById(Long id);
}
