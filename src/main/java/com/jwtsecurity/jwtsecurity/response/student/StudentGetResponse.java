package com.jwtsecurity.jwtsecurity.response.student;

import com.jwtsecurity.jwtsecurity.response.address.AddressGetResponse;
import com.jwtsecurity.jwtsecurity.response.subject.SubjectGetResponse;
import lombok.Data;

import java.util.List;

@Data
public class StudentGetResponse {

    private Long id;

    private String name;

    private String surname;

    private AddressGetResponse address;

    private List<SubjectGetResponse> subjects;

}
