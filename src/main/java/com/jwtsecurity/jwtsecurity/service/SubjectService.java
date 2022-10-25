package com.jwtsecurity.jwtsecurity.service;

import com.jwtsecurity.jwtsecurity.request.subject.SubjectCreateRequest;
import com.jwtsecurity.jwtsecurity.request.subject.SubjectUpdateRequest;
import com.jwtsecurity.jwtsecurity.response.subject.SubjectGetResponse;
import com.jwtsecurity.jwtsecurity.response.result.*;

import java.util.List;

public interface SubjectService {

    DataResult<List<SubjectGetResponse>> getAllSubjects();

    DataResult<SubjectGetResponse> getSubjectBySubjectId(Long subjectId);

    DataResult<SubjectGetResponse> createSubject(SubjectCreateRequest subjectCreateRequest);

    DataResult<SubjectGetResponse> updateSubject(Long subjectId, SubjectUpdateRequest subjectCreateRequest);

    Result deleteSubject(Long subjectId);

}
