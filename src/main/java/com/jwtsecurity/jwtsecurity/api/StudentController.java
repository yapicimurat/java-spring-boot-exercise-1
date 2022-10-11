package com.jwtsecurity.jwtsecurity.api;
import com.jwtsecurity.jwtsecurity.request.address.AddressCreateRequest;
import com.jwtsecurity.jwtsecurity.request.address.AddressUpdateRequest;
import com.jwtsecurity.jwtsecurity.request.student.StudentCreateRequest;
import com.jwtsecurity.jwtsecurity.request.student.StudentUpdateRequest;
import com.jwtsecurity.jwtsecurity.response.AddressGetResponse;
import com.jwtsecurity.jwtsecurity.response.StudentGetResponse;
import com.jwtsecurity.jwtsecurity.response.result.DataResult;
import com.jwtsecurity.jwtsecurity.response.result.Result;
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
    public ResponseEntity<DataResult<StudentGetResponse>> updateStudent(@RequestParam("id") Long studentId,@RequestBody StudentUpdateRequest studentUpdateRequest){
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

}