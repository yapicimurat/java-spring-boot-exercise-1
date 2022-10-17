package com.jwtsecurity.jwtsecurity.service;

import com.jwtsecurity.jwtsecurity.exception.EntityNotFoundException;
import com.jwtsecurity.jwtsecurity.request.address.AddressCreateRequest;
import com.jwtsecurity.jwtsecurity.request.address.AddressUpdateRequest;
import com.jwtsecurity.jwtsecurity.request.student.StudentCreateRequest;
import com.jwtsecurity.jwtsecurity.request.student.StudentUpdateRequest;
import com.jwtsecurity.jwtsecurity.request.studentSubject.StudentSubjectCreateRequest;
import com.jwtsecurity.jwtsecurity.request.studentSubject.StudentSubjectUpdateRequest;
import com.jwtsecurity.jwtsecurity.response.AddressGetResponse;
import com.jwtsecurity.jwtsecurity.response.SubjectGetResponse;
import com.jwtsecurity.jwtsecurity.response.student.StudentGetResponse;
import com.jwtsecurity.jwtsecurity.response.result.*;

import java.util.List;
public interface StudentService {

    DataResult<List<StudentGetResponse>> getAllStudents();

    DataResult<StudentGetResponse> getStudentById(Long studentId) throws EntityNotFoundException;

    DataResult<StudentGetResponse> createStudent(StudentCreateRequest studentCreateRequest);

    DataResult<StudentGetResponse> updateStudent(Long studentId, StudentUpdateRequest studentUpdateRequest)  throws EntityNotFoundException;

    Result deleteStudent(Long studentId) throws EntityNotFoundException;

    //ADDRESS

    DataResult<AddressGetResponse> getStudentAddress(Long studentId);

    DataResult<AddressGetResponse> addStudentAddress(Long studentId, AddressCreateRequest addressCreateRequest);

    DataResult<AddressGetResponse> updateStudentAddress(Long studentId, AddressUpdateRequest addressUpdateRequest);

    Result deleteAddress(Long studentId);

    //SUBJECT
    DataResult<List<SubjectGetResponse>> getStudentSubjectsByStudentId(Long studentId);

    DataResult<SubjectGetResponse> addStudentSubject(StudentSubjectCreateRequest studentSubjectCreateRequest);

    DataResult<StudentGetResponse> updateStudentSubject(Long targetSubjectId, StudentSubjectUpdateRequest studentSubjectUpdateRequest);

    Result deleteStudentSubject(final Long studentId, final Long subjectId);
}
