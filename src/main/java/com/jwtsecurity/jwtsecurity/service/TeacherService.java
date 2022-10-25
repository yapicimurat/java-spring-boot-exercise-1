package com.jwtsecurity.jwtsecurity.service;

import com.jwtsecurity.jwtsecurity.exception.EntityNotFoundException;
import com.jwtsecurity.jwtsecurity.request.teacher.TeacherCreateRequest;
import com.jwtsecurity.jwtsecurity.request.teacher.TeacherUpdateRequest;
import com.jwtsecurity.jwtsecurity.request.teachersubject.TeacherSubjectCreateRequest;
import com.jwtsecurity.jwtsecurity.request.teachersubject.TeacherSubjectUpdateRequest;
import com.jwtsecurity.jwtsecurity.response.subject.SubjectGetResponse;
import com.jwtsecurity.jwtsecurity.response.teacher.TeacherGetResponse;
import com.jwtsecurity.jwtsecurity.response.result.*;

import java.util.List;

public interface TeacherService {

    DataResult<List<TeacherGetResponse>> getAllTeachers();

    DataResult<TeacherGetResponse> getTeacherById(Long teacherId) throws EntityNotFoundException;

    DataResult<TeacherGetResponse> createTeacher(TeacherCreateRequest teacherCreateRequest);

    DataResult<TeacherGetResponse> updateTeacher(Long teacherId, TeacherUpdateRequest teacherUpdateRequest) throws EntityNotFoundException;

    Result deleteTeacher(Long teacherId) throws EntityNotFoundException;


    //SUBJECT
    DataResult<List<SubjectGetResponse>> getTeacherSubjectsByTeacherId(Long teacherId);

    DataResult<SubjectGetResponse> createTeacherSubject(TeacherSubjectCreateRequest teacherSubjectCreateRequest);

    DataResult<SubjectGetResponse> updateTeacherSubject(Long targetSubject, TeacherSubjectUpdateRequest teacherSubjectUpdateRequest);

    Result deleteTeacherSubject(Long teacherId, Long subjectId);

}
