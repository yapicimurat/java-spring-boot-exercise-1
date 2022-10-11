package com.jwtsecurity.jwtsecurity.response;

import lombok.Data;

@Data
public abstract class StudentGetResponse {

    private Long id;

    private String name;

    private String surname;

    //sonra alt entity'leri ekle...
}
