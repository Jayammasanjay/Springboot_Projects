package com.example.student.Service;

import com.example.student.Exception.IdNotFoundException;
import com.example.student.Repository.MarksRespository;
import com.example.student.Repository.StudentRepository;
import com.example.student.entity.Marks;
import com.example.student.entity.MarksDTO;
import com.example.student.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MarksService {

    @Autowired
    private MarksRespository respository;
    @Autowired
    private StudentRepository studentRepository;

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

    //find all the marks of student by name
    public List<MarksDTO> getMarksByStudentName(String studentName) {
        List<Marks> marksList = respository.findByStudent_StudentName(studentName);
        return marksList.stream()
                .map(MarksDTO::new)
                .collect(Collectors.toList());
    }

    //find all the marks by student Id
    public List<MarksDTO> getMarksByStudentId(Long studentId) {
        // First, check if the student exists
        Optional<?> student = studentRepository.findById(studentId);

        if (!student.isPresent()) {
            throw new IdNotFoundException("Student ID: " + studentId + " not found.");
        }

        // If student exists, check if marks are updated
        List<Marks> marksList = respository.findBystudent_studentRollNo(studentId);

        if (marksList.isEmpty()) {
            throw new IdNotFoundException("Marks not updated for Student ID: " + studentId);
        }

        // If marks exist, return them as MarksDTOs
        return marksList.stream()
                .map(MarksDTO::new)
                .collect(Collectors.toList());
    }


    // Method to get all marks for a particular subject
    public List<MarksDTO> getMarksBySubjectName(String subjectName) {
        List<Marks> marksList = respository.findAllBySubjectName(subjectName); // Fetch marks by subject name
        // Map Marks entity to MarksDTO and return as list
        return marksList.stream()
                .map(marks -> new MarksDTO(marks.getStudent().getStudentName(),
                        marks.getSubject().getSubjectName(),
                        marks.getMarks(),
                        marks.getStatus()))
                .collect(Collectors.toList());
    }

}
