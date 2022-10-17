package com.jwtsecurity.jwtsecurity.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@ToString
public class Student extends BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String surname;


    //Student -> Address; One-to-One relation...
    @OneToOne(mappedBy = "student", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Address address;


    //Student -> Student_Subject; One-to-Many relation | Subject -> Student; One-to-Many relation
    //then Student -> Subject; Many-to-Many relation...

    @ManyToMany
    @JoinTable(
        name = "student_subject",
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name = "subject_id"))
    List<Subject> subjects;

}

















