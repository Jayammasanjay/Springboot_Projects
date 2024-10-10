package com.example.student.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Teachers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long teacherId;
    private String teacherName;
    private LocalDate dateOfBirth;
    private String subjectOne;
    private String subjectTwo;

    public String getSubjectTwo() {
        return subjectTwo;
    }

    public void setSubjectTwo(String subjectTwo) {
        this.subjectTwo = subjectTwo;
    }

    public String getSubjectOne() {
        return subjectOne;
    }

    public void setSubjectOne(String subjectOne) {
        this.subjectOne = subjectOne;
    }


    public long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(long teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
