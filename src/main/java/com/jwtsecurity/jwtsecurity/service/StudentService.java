package com.jwtsecurity.jwtsecurity.service;

import com.jwtsecurity.jwtsecurity.exception.EntityNotFoundException;
import com.jwtsecurity.jwtsecurity.request.address.AddressCreateRequest;
import com.jwtsecurity.jwtsecurity.request.address.AddressUpdateRequest;
import com.jwtsecurity.jwtsecurity.request.student.StudentCreateRequest;
import com.jwtsecurity.jwtsecurity.request.student.StudentUpdateRequest;
import com.jwtsecurity.jwtsecurity.response.AddressGetResponse;
import com.jwtsecurity.jwtsecurity.response.StudentGetResponse;
import com.jwtsecurity.jwtsecurity.response.result.*;
import org.springframework.stereotype.Service;

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

}
