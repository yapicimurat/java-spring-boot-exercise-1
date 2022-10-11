package com.jwtsecurity.jwtsecurity.model;

import lombok.Data;

import java.time.LocalDate;


@Data
public class BaseModel {

    private LocalDate createdAt;

    private LocalDate modifiedAt;

    private LocalDate deletedAt;

}
