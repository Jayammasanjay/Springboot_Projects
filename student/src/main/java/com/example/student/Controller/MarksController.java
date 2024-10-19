package com.example.student.Controller;

import com.example.student.Exception.IdNotFoundException;
import com.example.student.Service.MarksService;
import com.example.student.entity.Marks;
import com.example.student.entity.MarksDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Marks")
public class MarksController {

    @Autowired
    private MarksService service;


    @GetMapping("/details")
    public ResponseEntity<List<MarksDTO>> getAllMarksDetails() {
        List<MarksDTO> marks= service.getAllMarksWithDetails();

        if(marks.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(marks);
    }

    //Adding a single record
    @PostMapping("/add")
    public ResponseEntity<Marks> addMarks(@RequestBody Marks marks) {
        Marks savedMarks = service.add(marks);
        return new ResponseEntity<>(savedMarks, HttpStatus.CREATED);
    }
//Getting all marks by student name
@GetMapping("/student/{studentName}")
public ResponseEntity<?> getMarksByStudentName(@PathVariable("studentName") String studentName) {
    List<MarksDTO> marks = service.getMarksByStudentName(studentName);
    if (marks.isEmpty()){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student with this name Not Found");
    }
    System.out.println(marks);
    return ResponseEntity.ok(marks);
}

//Getting all Marks By ID
@GetMapping("/student/id/{studentId}")
public ResponseEntity<List<MarksDTO>> getMarksByStudentId(@PathVariable Long studentId) {
    List<MarksDTO> marks = service.getMarksByStudentId(studentId);

    if (marks.isEmpty()) {
    throw new IdNotFoundException("StudentId"+studentId+"Not Found");
    }

    return ResponseEntity.ok(marks);
}



    //Getting all marks of the subject
    @GetMapping("/subject/{subjectName}")
    public ResponseEntity<?> getMarksBySubjectName(@PathVariable String subjectName) {
        List<MarksDTO> marks = service.getMarksBySubjectName(subjectName);

        if (marks.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Subject Not Found");
        }
        return ResponseEntity.ok(marks);
    }

}
