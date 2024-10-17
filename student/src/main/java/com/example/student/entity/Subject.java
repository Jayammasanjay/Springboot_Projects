package com.example.student.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long subjectId;
   private String subjectName;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
   @JsonBackReference
   private Teachers subjectThoughtBy;

    public Teachers getSubjectThoughtBy() {
        return subjectThoughtBy;
    }

    public void setSubjectThoughtBy(Teachers subjectThoughtBy) {
        this.subjectThoughtBy = subjectThoughtBy;
    }



    public long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(long subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subjectId=" + subjectId +
                ", subjectName='" + subjectName + '\'' +
                ", subjectThoughtBy=" + subjectThoughtBy +
                '}';
    }
}
