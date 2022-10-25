package com.jwtsecurity.jwtsecurity.response.teacher;

import com.jwtsecurity.jwtsecurity.response.subject.SubjectGetResponse;
import lombok.Data;

import java.util.List;

@Data
public class TeacherGetResponse {

    private Long id;

    private String name;

    private String surname;

    private List<SubjectGetResponse> subjects;

}
