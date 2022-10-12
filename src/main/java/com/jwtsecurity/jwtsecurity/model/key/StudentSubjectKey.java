package com.jwtsecurity.jwtsecurity.model.key;


import lombok.Data;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Objects;

@Data
public class StudentSubjectKey implements Serializable {

    @Column(name = "student_id")
    public Long studentId;

    @Column(name = "subject_id")
    public Long subjectId;


    @Override
    public boolean equals(Object x){
        if(this == x){
            return true;
        }if(x == null){
            return false;
        }if(getClass() != x.getClass()){
            return false;
        }

        StudentSubjectKey other = (StudentSubjectKey)x;
        return studentId.equals(other.studentId) &&
                subjectId.equals(other.subjectId);
    }

    @Override
    public int hashCode(){
        return Objects.hash(studentId, subjectId);
    }
}
