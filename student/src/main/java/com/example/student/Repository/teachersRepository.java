package com.example.student.Repository;

import com.example.student.entity.Teachers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface teachersRepository extends JpaRepository<Teachers, Long> {

    Teachers findByTeacherName(String teacherName);

    List<Teachers> findByTeacherNameContaining(String teacherName);
}
