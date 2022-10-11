package com.jwtsecurity.jwtsecurity.api;

import com.jwtsecurity.jwtsecurity.request.teacher.TeacherCreateRequest;
import com.jwtsecurity.jwtsecurity.request.teacher.TeacherUpdateRequest;
import com.jwtsecurity.jwtsecurity.response.TeacherGetResponse;
import com.jwtsecurity.jwtsecurity.response.result.DataResult;
import com.jwtsecurity.jwtsecurity.response.result.Result;
import com.jwtsecurity.jwtsecurity.service.TeacherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teacher")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService)
    {
        this.teacherService = teacherService;
    }


    @GetMapping
    public ResponseEntity<DataResult<List<TeacherGetResponse>>> getAllTeachers()
    {
        return ResponseEntity.ok(teacherService.getAllTeachers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataResult<TeacherGetResponse>> getTeacherByTeacherId(@PathVariable("id") Long teacherId){
        return ResponseEntity.ok(teacherService.getTeacherById(teacherId));
    }


    @PostMapping
    public ResponseEntity<DataResult<TeacherGetResponse>> createTeacher(@RequestBody TeacherCreateRequest teacherCreateRequest){
        return ResponseEntity.ok(teacherService.createTeacher(teacherCreateRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DataResult<TeacherGetResponse>> updateTeacher(@PathVariable("id") Long teacherId, @RequestBody TeacherUpdateRequest teacherUpdateRequest){
        return ResponseEntity.ok(teacherService.updateTeacher(teacherId, teacherUpdateRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Result> deleteTeacher(@PathVariable("id") Long teacherId){
        return ResponseEntity.ok(teacherService.deleteTeacher(teacherId));
    }
}
