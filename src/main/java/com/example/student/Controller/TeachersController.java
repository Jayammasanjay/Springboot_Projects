package com.example.student.Controller;

import com.example.student.Service.TeachersService;
import com.example.student.entity.Teachers;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Teachers")
public class TeachersController {


    @Autowired
    private TeachersService teachersService;

    @PostMapping("/add")
    public Teachers add(@RequestBody Teachers teachers) {
        return teachersService.add(teachers);
    }

    @PostMapping("/addListOfTeachers")
    public List<Teachers> addlist(@RequestBody List<Teachers> teachers) {
        return teachersService.addList(teachers);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Teachers> getById(@PathVariable("id") long id) {
        Optional<Teachers> teacher = teachersService.getById(id);

        if (teacher.isPresent()) {
            return ResponseEntity.ok(teacher.get()); // Return 200 OK with teacher details
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(null); // Return 404 Not Found with an empty body
        }
    }



    @GetMapping("/getAllTeachers")
    public List<Teachers> get() {
        return teachersService.listOfData();
    }

    //get the data by name
    @GetMapping("/getByName/{name}")
    public ResponseEntity<Teachers> getTeacherByName(@PathVariable("name") String name) {
        Teachers teacher = teachersService.getTeacherByName(name).getBody();
        if (teacher != null) {
            return ResponseEntity.ok(teacher); // Return 200 OK with teacher details
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Return 404 with an empty body
        }
    }



    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") long id) {
        Optional<Teachers> teacher = teachersService.deleteById(id);

        // Check if the teacher was found and deleted
        if (teacher.isPresent()) {
            return ResponseEntity.ok("Teacher with ID " + id + " deleted successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Teacher with ID " + id + " not found.");
        }
    }
}

