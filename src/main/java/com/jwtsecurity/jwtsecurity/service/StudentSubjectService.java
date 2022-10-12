package com.jwtsecurity.jwtsecurity.service;

import com.jwtsecurity.jwtsecurity.request.studentSubject.StudentSubjectCreateRequest;
import com.jwtsecurity.jwtsecurity.request.studentSubject.StudentSubjectUpdateRequest;
import com.jwtsecurity.jwtsecurity.response.SubjectGetResponse;
import com.jwtsecurity.jwtsecurity.response.result.*;

public interface StudentSubjectService {


    Result deleteStudentSubjectByStudentIdAndSubjectId(Long studentId, Long subjectId);

    Result deleteStudentSubjectsByStudentId(Long studentId);

    Result deleteStudentSubjectsBySubjectId(Long subjectId);


}
