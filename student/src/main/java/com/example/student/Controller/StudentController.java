package com.example.student.Controller;

import com.example.student.entity.Student;
import com.example.student.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/addlist")
    public ResponseEntity<List<Student>> addlist(@RequestBody List<Student> student) {
        return ResponseEntity.ok(studentService.addData(student));
    }

    @PostMapping("/add")
    public ResponseEntity<Student> add(@RequestBody Student student) {
        return ResponseEntity.ok(studentService.add(student));
    }

    @GetMapping("/get")
    public ResponseEntity<List<Student>> get() {
        return ResponseEntity.ok(studentService.get());
    }

    @GetMapping("/getData/{id}")
    public ResponseEntity<Student> getData(@PathVariable("id") long id) {
        Optional<Student> student = studentService.getById(id);

        return student.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Student> delete(@PathVariable("id") long id) {
        Optional<Student> student = studentService.deleteById(id);

        return student.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/deleteList")
    public ResponseEntity<Void> delete(@RequestBody List<Long> ids) {
        boolean allDeleted = studentService.deleteByIds(ids);

        if (allDeleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(404).build();
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Student> update(@PathVariable("id") long id, @RequestBody Student updateStudent) {
        Optional<Student> student = studentService.updateById(id, updateStudent);
        if (student.isPresent()) {
            return ResponseEntity.ok(student.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/updateList")
    public ResponseEntity<List<Student>> updateList(@RequestBody List<Student> students) {
        List<Student> updatedStudents = studentService.updateStudents(students);
        return ResponseEntity.ok(updatedStudents);
    }

}
