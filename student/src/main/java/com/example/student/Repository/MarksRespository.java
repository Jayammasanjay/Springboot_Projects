package com.example.student.Repository;

import com.example.student.entity.Marks;
import com.example.student.entity.MarksDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface MarksRespository extends JpaRepository<Marks,Long> {

    @Query("SELECT new com.example.student.entity.MarksDTO(s.studentName, sub.subjectName, m.marks, m.status) " +
            "FROM Marks m JOIN m.student s JOIN m.subject sub")
    List<MarksDTO> findAllMarksWithStudentAndSubjectNames();

    List<Marks> findByStudent_StudentName(String studentName);

    List<Marks> findBystudent_studentRollNo(Long studentId);

    // Fetch all marks for a specific subject by subject name
    @Query("SELECT m FROM Marks m JOIN m.subject s WHERE s.subjectName = :subjectName")
    List<Marks> findAllBySubjectName(@Param("subjectName") String subjectName);

}
