package com.jwtsecurity.jwtsecurity.response.student;

import com.jwtsecurity.jwtsecurity.model.Subject;
import com.jwtsecurity.jwtsecurity.response.SubjectGetResponse;
import lombok.Data;

import java.util.List;

@Data
public class StudentGetResponse {

    private Long id;

    private String name;

    private String surname;

    private List<SubjectGetResponse> subjects;

}
