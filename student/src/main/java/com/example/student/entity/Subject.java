package com.example.student.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Subject {
    @Id
    long subjectId;
    String subjectName;
    String subjectThoughtBy;

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

    public String getSubjectThoughtBy() {
        return subjectThoughtBy;
    }

    public void setSubjectThoughtBy(String subjectThoughtBy) {
        this.subjectThoughtBy = subjectThoughtBy;
    }
}
