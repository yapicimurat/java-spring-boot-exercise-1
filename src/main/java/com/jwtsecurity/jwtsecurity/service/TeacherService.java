package com.jwtsecurity.jwtsecurity.service;

import com.jwtsecurity.jwtsecurity.exception.EntityNotFoundException;
import com.jwtsecurity.jwtsecurity.request.teacher.TeacherCreateRequest;
import com.jwtsecurity.jwtsecurity.request.teacher.TeacherUpdateRequest;
import com.jwtsecurity.jwtsecurity.response.TeacherGetResponse;
import com.jwtsecurity.jwtsecurity.response.result.*;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TeacherService {

    DataResult<List<TeacherGetResponse>> getAllTeachers();

    DataResult<TeacherGetResponse> getTeacherById(Long teacherId) throws EntityNotFoundException;

    DataResult<TeacherGetResponse> createTeacher(TeacherCreateRequest teacherCreateRequest);

    DataResult<TeacherGetResponse> updateTeacher(Long teacherId, TeacherUpdateRequest teacherUpdateRequest) throws EntityNotFoundException;

    Result deleteTeacher(Long teacherId) throws EntityNotFoundException;

}
