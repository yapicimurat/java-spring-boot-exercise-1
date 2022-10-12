package com.jwtsecurity.jwtsecurity.repository;

import com.jwtsecurity.jwtsecurity.model.StudentSubject;
import com.jwtsecurity.jwtsecurity.model.key.StudentSubjectKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentSubjectRepository extends JpaRepository<StudentSubject, StudentSubjectKey> {

    StudentSubject getStudentSubjectByStudentIdAndSubjectId(Long studentId, Long subjectId);

    List<StudentSubject> getStudentSubjectsByStudentId(Long studentId);

    List<StudentSubject> getStudentSubjectsBySubjectId(Long studentId);

    List<StudentSubject> findAll();

    void deleteStudentSubjectByStudentId(Long studentId);
}
