package com.friday.School.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Set;

@JsonIdentityInfo
        (
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
        )
@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;


    @OneToMany(mappedBy = "teacher")
    private Set<Subject> SubjectSet;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Set<Subject> getSubjectSet() {
        return SubjectSet;
    }

    public void setSubjectSet(Set<Subject> subjectSet) {
        SubjectSet = subjectSet;
    }
}
