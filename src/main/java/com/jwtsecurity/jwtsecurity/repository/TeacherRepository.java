package com.jwtsecurity.jwtsecurity.repository;

import com.jwtsecurity.jwtsecurity.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    List<Teacher> findAll();

    Teacher getTeacherById(Long teacherId);

}
