//package com.example.student.entity;
//
//import jakarta.persistence.*;
//import lombok.*;
//
//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Setter
//@Entity
//@Table(name = "MARKS")
//public class Marks {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long marksId;
//
//    // Mapping with the Student entity
//    @ManyToOne
//    @JoinColumn(name = "student_id", referencedColumnName = "studentRollNo")
//    private Student student;
//
//    // Mapping with the Subject entity
//    @ManyToOne
//    @JoinColumn(name = "subject_id", referencedColumnName = "subjectId")
//    private Subject subject;
//
//    private int marks;
//}
