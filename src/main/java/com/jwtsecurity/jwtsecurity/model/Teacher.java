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

    @ManyToMany
    @JoinTable(
            name = "teacher_subject",
            joinColumns = @JoinColumn(name = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id")
    )
    private List<Subject> subjects;

}
