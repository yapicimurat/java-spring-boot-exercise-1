package com.jwtsecurity.jwtsecurity.model;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
public class Address extends BaseModel{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String address;

    //Address -> Student; One-to-One relation
    @OneToOne
    @JoinColumn(name = "student_id")
    private Student student;

}
