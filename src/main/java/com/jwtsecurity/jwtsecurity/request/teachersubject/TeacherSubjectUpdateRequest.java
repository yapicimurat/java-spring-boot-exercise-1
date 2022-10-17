package com.jwtsecurity.jwtsecurity.request.teachersubject;

import lombok.Data;

@Data
public class TeacherSubjectUpdateRequest {

    private Long teacherId;

    private Long subjectId;
}
