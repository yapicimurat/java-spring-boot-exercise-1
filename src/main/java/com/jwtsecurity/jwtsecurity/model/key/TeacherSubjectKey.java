package com.jwtsecurity.jwtsecurity.model.key;


import lombok.Data;

import javax.persistence.Column;
import java.io.Serializable;

@Data
public class TeacherSubjectKey implements Serializable {

    @Column(name = "teacher_id")
    private Long teacherId;

    @Column(name = "subject_id")
    private Long subjectId;
}
