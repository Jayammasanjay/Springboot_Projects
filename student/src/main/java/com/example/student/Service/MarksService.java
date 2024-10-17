package com.example.student.Service;

import com.example.student.Repository.MarksRespository;
import com.example.student.entity.Marks;
import com.example.student.entity.MarksDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MarksService {

    @Autowired
    private MarksRespository respository;


    //getting the All student marks
    public List<MarksDTO> getAllMarksWithDetails() {
        List<Marks> marksList = respository.findAll();  // Fetch all marks records
        // Convert each Marks entity to MarksDTO
        return marksList.stream()
                .map(MarksDTO::new)  // Use the new constructor to create MarksDTO
                .collect(Collectors.toList());
    }

    //Adding a single  marks

    public Marks add(Marks marks){
        return respository.save(marks);
    }

    //find all the marks of student
    public List<MarksDTO> getMarksByStudentName(String studentName) {
        List<Marks> marksList = respository.findByStudent_StudentName(studentName);
        return marksList.stream()
                .map(MarksDTO::new)
                .collect(Collectors.toList());
    }
    public List<MarksDTO> getMarksByStudentId(Long studentId) {
        List<Marks> marksList = respository.findBystudent_studentRollNo(studentId);
        return marksList.stream()
                .map(MarksDTO::new)
                .collect(Collectors.toList());
    }

}
