package com.jwtsecurity.jwtsecurity.response;

import lombok.Data;

@Data
public abstract class TeacherGetResponse {

    private Long id;

    private String name;

    private String surname;

}
