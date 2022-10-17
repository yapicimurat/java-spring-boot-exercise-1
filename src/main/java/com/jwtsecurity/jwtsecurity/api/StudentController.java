package com.jwtsecurity.jwtsecurity.api;

import com.jwtsecurity.jwtsecurity.request.address.AddressCreateRequest;
import com.jwtsecurity.jwtsecurity.request.address.AddressUpdateRequest;
import com.jwtsecurity.jwtsecurity.request.student.StudentCreateRequest;
import com.jwtsecurity.jwtsecurity.request.student.StudentUpdateRequest;
import com.jwtsecurity.jwtsecurity.request.studentSubject.StudentSubjectCreateRequest;
import com.jwtsecurity.jwtsecurity.request.studentSubject.StudentSubjectUpdateRequest;
import com.jwtsecurity.jwtsecurity.response.AddressGetResponse;
import com.jwtsecurity.jwtsecurity.response.SubjectGetResponse;
import com.jwtsecurity.jwtsecurity.response.result.DataResult;
import com.jwtsecurity.jwtsecurity.response.result.Result;
import com.jwtsecurity.jwtsecurity.response.student.StudentGetResponse;
import com.jwtsecurity.jwtsecurity.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<DataResult<List<StudentGetResponse>>> getAllStudent(){
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataResult<StudentGetResponse>> getStudentById(@PathVariable("id") Long studentId){
        return ResponseEntity.ok(studentService.getStudentById(studentId));
    }

    @PostMapping
    public ResponseEntity<DataResult<StudentGetResponse>> createStudent(@RequestBody StudentCreateRequest studentCreateRequest){
        return ResponseEntity.ok(studentService.createStudent(studentCreateRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DataResult<StudentGetResponse>> updateStudent(@PathVariable("id") Long studentId, @RequestBody StudentUpdateRequest studentUpdateRequest){
        return ResponseEntity.ok(studentService.updateStudent(studentId, studentUpdateRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Result> deleteStudent(@PathVariable("id") Long studentId){
        return ResponseEntity.ok(studentService.deleteStudent(studentId));
    }

    //ADDRESS
    @GetMapping("/{id}/address")
    public ResponseEntity<DataResult<AddressGetResponse>> getStudentAddressByStudentId(@PathVariable("id") Long studentId){
        return ResponseEntity.ok(studentService.getStudentAddress(studentId));
    }

    @PostMapping("/{id}/address")
    public ResponseEntity<DataResult<AddressGetResponse>> createStudentAddress(@PathVariable("id") Long studentId, @RequestBody AddressCreateRequest addressCreateRequest){

        return ResponseEntity.ok(studentService.addStudentAddress(studentId, addressCreateRequest));
    }

    @PutMapping("/{id}/address")
    public ResponseEntity<DataResult<AddressGetResponse>> updateStudentAddress(@PathVariable("id") Long studentId, @RequestBody AddressUpdateRequest addressUpdateRequest){
        return ResponseEntity.ok(studentService.updateStudentAddress(studentId, addressUpdateRequest));
    }

    @DeleteMapping("/{id}/address")
    public ResponseEntity<Result> deleteStudentAddress(@PathVariable("id") Long studentId){
        return ResponseEntity.ok(studentService.deleteStudent(studentId));
    }

    //SUBJECT
    @GetMapping("/{id}/subject")
    public ResponseEntity<DataResult<List<SubjectGetResponse>>> getStudentSubjectsByStudentId(@PathVariable("id") Long studentId){
        return ResponseEntity.ok(studentService.getStudentSubjectsByStudentId(studentId));
    }

    @PostMapping("/subject")
    public ResponseEntity<DataResult<SubjectGetResponse>> createStudentSubject(@RequestBody StudentSubjectCreateRequest studentSubjectCreateRequest){
        return ResponseEntity.ok((studentService.addStudentSubject(studentSubjectCreateRequest)));
    }

    @PutMapping("/subject/{targetSubjectId}")
    public ResponseEntity<DataResult<StudentGetResponse>> updateStudentSubject(@PathVariable("targetSubjectId") Long targetSubjectId, @RequestBody StudentSubjectUpdateRequest studentSubjectUpdateRequest){
        return ResponseEntity.ok(studentService.updateStudentSubject(targetSubjectId, studentSubjectUpdateRequest));
    }

    @DeleteMapping("/{studentId}/subject/{subjectId}")
    public ResponseEntity<Result> deleteStudentSubject(@PathVariable("studentId") Long studentId, @PathVariable("subjectId") Long subjectId){
        return ResponseEntity.ok(studentService.deleteStudentSubject(studentId, subjectId));
    }
}