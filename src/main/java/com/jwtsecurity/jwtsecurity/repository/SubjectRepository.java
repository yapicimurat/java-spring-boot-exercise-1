package com.jwtsecurity.jwtsecurity.repository;

import com.jwtsecurity.jwtsecurity.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject, Long> {

    Subject getSubjectById(Long subjectId);

    List<Subject> findAll();
}
