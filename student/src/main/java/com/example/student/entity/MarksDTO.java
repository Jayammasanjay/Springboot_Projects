package com.example.student.entity;


public class MarksDTO {

    private String studentName;
    private String subjectName;
    private int marks;   // Matches the marks in the Marks entity
    private String status;  // Matches the status in the Marks entity

    // Constructor to map from Marks entity to DTO
    public MarksDTO(Marks marks) {
        this.studentName = marks.getStudent().getStudentName();  // Get student name from Student entity
        this.subjectName = marks.getSubject().getSubjectName();  // Get subject name from Subject entity
        this.marks = marks.getMarks();  // Get marks from Marks entity
        this.status = marks.getStatus();  // Get status from Marks entity
    }
    public MarksDTO(String studentName, String subjectName, int marks, String status) {
        this.studentName = studentName;
        this.subjectName = subjectName;
        this.marks = marks;
        this.status = status;
    }



    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "MarksDto{" +
                "studentName='" + studentName + '\'' +
                ", subjectName='" + subjectName + '\'' +
                ", marks=" + marks +
                ", status='" + status + '\'' +
                '}';
    }
}
