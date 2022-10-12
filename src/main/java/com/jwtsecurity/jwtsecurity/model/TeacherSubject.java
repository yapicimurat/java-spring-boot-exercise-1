package com.jwtsecurity.jwtsecurity.model;

import com.jwtsecurity.jwtsecurity.model.key.TeacherSubjectKey;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@IdClass(TeacherSubjectKey.class)
public class TeacherSubject {

    @Id
    private Long teacherId;
    @Id
    private Long subjectId;

    @ManyToOne
    @MapsId("teacherId")
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @ManyToOne
    @MapsId("subjectId")
    @JoinColumn(name = "subject_id")
    private Subject subject;



}