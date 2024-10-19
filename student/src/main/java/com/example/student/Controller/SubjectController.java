package com.example.student.Controller;

import com.example.student.Service.SubjectService;
import com.example.student.entity.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/subjects")
public class SubjectController {

    @Autowired
    private SubjectService service;

    @PostMapping("/addSubjectData")
    public ResponseEntity<Subject> add(@RequestBody Subject subject){
        return ResponseEntity.ok(service.add(subject));
    }

    @GetMapping("/GetById/{id}")
    public ResponseEntity<Optional<Subject>> getById(@PathVariable("id") long id){
        Optional<Subject> subject=service.getById(id);
        System.out.println(subject);
        if(subject.isPresent()){
            return ResponseEntity.ok(subject);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    //Getting All Subject Data
    @GetMapping("/GetAllSubjects")
    public ResponseEntity<List<Subject>> getAll() {
        List<Subject> subjects = service.getAll();
        return ResponseEntity.ok(subjects);
    }
}
