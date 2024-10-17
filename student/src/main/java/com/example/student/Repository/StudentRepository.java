package com.example.student.Repository;

import com.example.student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface StudentRepository extends JpaRepository<Student, Long> {

    public List<Student> findByStudentName(String studentName);

    //find by starting letter
  public   List<Student> findByStudentNameStartingWith(String prefix);


}
