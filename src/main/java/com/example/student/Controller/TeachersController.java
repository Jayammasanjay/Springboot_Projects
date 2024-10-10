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

    @PostMapping ("/add")
    public Teachers add(@RequestBody Teachers teachers){
        return teachersService.add(teachers);
    }

    @PostMapping("/addListOfTeachers")
    public List<Teachers> addlist(@RequestBody List<Teachers> teachers){
        return teachersService.addList(teachers);
    }


    @GetMapping("/get/{id}")
    public Optional<Teachers> getById(@PathVariable("id")long id){
        return teachersService.getById(id);
    }


    @GetMapping("/getAllTeachers")
    public List<Teachers> get(){
        return teachersService.listOfData();
    }

    //get the data by name
    @GetMapping("/getByName/{name}")
    public ResponseEntity<Teachers> getTeacherByName(@PathVariable("name") String name) {
        Teachers teacher = teachersService.getTeacherByName(name).getBody();
        if (teacher != null) {
            return ResponseEntity.ok(teacher); // Return 200 OK with teacher details
        } else {
            return ResponseEntity.notFound().build();// Return 404 Not Found if not found
        }
    }
}
