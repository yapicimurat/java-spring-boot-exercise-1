package com.jwtsecurity.jwtsecurity.model;

import com.jwtsecurity.jwtsecurity.model.key.StudentSubjectKey;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@IdClass(StudentSubjectKey.class)
public class StudentSubject {

    @Id
    private Long studentId;

    @Id
    private Long subjectId;

    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @MapsId("subjectId")
    @JoinColumn(name = "subject_id")
    private Subject subject;



}
