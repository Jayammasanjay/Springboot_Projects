package com.example.student.Repository;

import com.example.student.entity.Teachers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface teachersRepository extends JpaRepository<Teachers, Long> {

    Teachers findByTeacherName(String teacherName);

    List<Teachers> findByTeacherNameContaining(String teacherName);
}
