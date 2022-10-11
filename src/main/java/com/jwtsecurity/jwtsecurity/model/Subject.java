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

    @ManyToMany(mappedBy = "subjects")
    private List<Student> students;


    @ManyToMany(mappedBy = "subjects")
    private List<Teacher> teachers;
}
