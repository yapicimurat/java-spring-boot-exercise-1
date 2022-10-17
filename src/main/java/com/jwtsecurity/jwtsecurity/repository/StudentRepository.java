package com.jwtsecurity.jwtsecurity.repository;

import com.jwtsecurity.jwtsecurity.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findAll();

    Student getStudentById(Long studentId);


}
