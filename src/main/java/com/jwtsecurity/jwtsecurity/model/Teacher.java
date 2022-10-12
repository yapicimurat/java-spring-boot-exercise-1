package com.jwtsecurity.jwtsecurity.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
public class Teacher extends BaseModel{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String surname;


    @OneToMany(mappedBy = "teacher")
    List<TeacherSubject> teacherSubject;



}
