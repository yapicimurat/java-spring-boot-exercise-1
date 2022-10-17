package com.jwtsecurity.jwtsecurity.response.student;

import com.jwtsecurity.jwtsecurity.model.Subject;
import lombok.Data;

import java.util.List;

@Data
public class StudentGetResponse {

    private Long id;

    private String name;

    private String surname;

    //private List<Subject> subjects;

}
