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
    public ResponseEntity<String> addTeacher(@RequestBody Teachers teacher) {
        boolean isAdded = teachersService.add(teacher);

        if (isAdded) {
            return ResponseEntity.ok("Teacher added successfully");
        } else {
            return ResponseEntity.status(500).body("Failed to add teacher");
        }
    }

    @PostMapping("/addListOfTeachers")
    public ResponseEntity<Boolean> addlist(@RequestBody List<Teachers> teachers) {
        boolean addlist=teachersService.addList(teachers);
        if(addlist){
            return ResponseEntity.ok(true);
        }else{
            return ResponseEntity.status(500).body(false);
        }
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
    public ResponseEntity<List<Teachers>> get() {
        List<Teachers> teachers=teachersService.listOfData();
        if(teachers.isEmpty()){
          return   ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(teachers);
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

    //getting the age
    @GetMapping("/{teacherId}")
    public ResponseEntity<String> getTeacherAge(@PathVariable long teacherId) {
        return teachersService.getTeacherAgeById(teacherId)
                .map(age -> ResponseEntity.ok("Teacher's age is: " + age))
                .orElse(ResponseEntity.notFound().build());
    }


}

