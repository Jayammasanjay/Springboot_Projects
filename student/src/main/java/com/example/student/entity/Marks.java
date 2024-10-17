package com.example.student.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "MARKS")
public class Marks {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long marksId;

   // Mapping with the Student entity
   @ManyToOne
   @JoinColumn(name = "student_id", referencedColumnName = "studentRollNo")
   private Student student;

   // Mapping with the Subject entity
   @ManyToOne
   @JoinColumn(name = "subject_id", referencedColumnName = "subjectId")
   private Subject subject;

   private int marks;
   private String status;

   public long getMarksId() {
      return marksId;
   }

   public void setMarksId(long marksId) {
      this.marksId = marksId;
   }

   public Student getStudent() {
      return student;
   }

   public void setStudent(Student student) {
      this.student = student;
   }

   public Subject getSubject() {
      return subject;
   }

   public void setSubject(Subject subject) {
      this.subject = subject;
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
      return "Marks{" +
              "marksId=" + marksId +
              ", student=" + student +
              ", subject=" + subject +
              ", marks=" + marks +
              ", status='" + status + '\'' +
              '}';
   }
}

