package com.jwtsecurity.jwtsecurity.model;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Subject extends BaseModel{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;


    @OneToMany(mappedBy = "subject")
    private List<StudentSubject> studentSubjects;


}
