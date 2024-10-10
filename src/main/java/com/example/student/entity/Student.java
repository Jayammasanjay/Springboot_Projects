package com.example.student.entity;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Student_Data")
public class Student {
    @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long studentRollNo;
    private String studentName;
    private String studentClass;

    public long getStudentRollNo() {
        return studentRollNo;
    }

    public void setStudentRollNo(long studentRollNo) {
        this.studentRollNo = studentRollNo;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }
}
