package com.jwtsecurity.jwtsecurity.request.studentSubject;

import lombok.Data;

@Data
public class StudentSubjectCreateRequest {

    private Long studentId;

    private Long subjectId;
}
