package com.jwtsecurity.jwtsecurity.api;

import com.jwtsecurity.jwtsecurity.request.subject.SubjectCreateRequest;
import com.jwtsecurity.jwtsecurity.request.subject.SubjectUpdateRequest;
import com.jwtsecurity.jwtsecurity.response.SubjectGetResponse;
import com.jwtsecurity.jwtsecurity.response.result.DataResult;
import com.jwtsecurity.jwtsecurity.response.result.Result;
import com.jwtsecurity.jwtsecurity.service.SubjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subject")
public class SubjectController {

    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService)
    {
        this.subjectService = subjectService;
    }


    @GetMapping
    public ResponseEntity<DataResult<List<SubjectGetResponse>>> getAllSubjects(){
        return ResponseEntity.ok(subjectService.getAllSubjects());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataResult<SubjectGetResponse>> getSubjectBySubjectId(@PathVariable("id") Long subjectId){
        return ResponseEntity.ok(subjectService.getSubjectBySubjectId(subjectId));
    }

    @PostMapping
    public ResponseEntity<DataResult<SubjectGetResponse>> createSubject(@RequestBody SubjectCreateRequest subjectCreateRequest){
        return ResponseEntity.ok(subjectService.createSubject(subjectCreateRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DataResult<SubjectGetResponse>> updateSubject(@PathVariable("id") Long subjectId, @RequestBody SubjectUpdateRequest subjectUpdateRequest){
        return ResponseEntity.ok(subjectService.updateSubject(subjectId, subjectUpdateRequest));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Result> deleteSubject(@PathVariable("id") Long subjectId){
        return ResponseEntity.ok(subjectService.deleteSubject(subjectId));
    }

}
