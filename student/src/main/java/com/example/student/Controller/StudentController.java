package com.example.student.Controller;

import com.example.student.entity.Student;
import com.example.student.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;



@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;


    //Getting all data which is stored in the Map
    @GetMapping("/map")
    public ResponseEntity<Map<Long, Student>> getAllStudentsAsMap() {
        Map<Long, Student> studentsMap =  studentService.getAllStudentsAsMap();
        return ResponseEntity.ok(studentsMap);
    }


    @GetMapping("/map/{id}")
    public ResponseEntity<Student> getStudentByRollNo(@PathVariable("id") long id) {
        Student student = studentService.getByIdMap(id);
        if (student != null) {
            return ResponseEntity.ok(student);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/map/name/{name}")
    public ResponseEntity<Student> getStudentDataByName(@PathVariable("name") String name){
        Student student= studentService.getByNameMap(name);
        if (student != null){
            return ResponseEntity.ok(student);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }




//------------------------------------------------------------------------------------------------------------------
//---------------------------------------------------------------------------------------------------------------------
    @PostMapping("/addlist")
public ResponseEntity<Boolean> addlist(@RequestBody List<Student> student) {
    boolean isAdded = studentService.addData(student);

    return ResponseEntity.ok(isAdded);

}


@PostMapping("/add")
public ResponseEntity<Boolean> add(@RequestBody Student student) {
    boolean isAdded = studentService.add(student);
    return ResponseEntity.ok(isAdded);
}



    //Getting all Student data
    @GetMapping("/get")
    public ResponseEntity<List<Student>> get() {
        List<Student> student=studentService.get();
        System.out.println(student);
        if (student.isEmpty()) {
            //Return Not found
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        // Return the list of students with a 200 OK status
       // return ResponseEntity.ok(student);// Both can use
        return ResponseEntity.of(Optional.of(student));
    }

    @GetMapping("/getData/{id}")
    public ResponseEntity<Student> getData(@PathVariable("id") long id) {
        Optional<Student> student = studentService.getById(id);
        System.out.println(student);
        return student.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    //Getting the data by name
    @GetMapping("/students/{studentName}")
    public ResponseEntity<List<Student>> getData(@PathVariable("studentName") String studentName) {
        List<Student> students = studentService.getByName(studentName); // Directly retrieve the list
        System.out.println(students);
        if (students.isEmpty()) {
            return ResponseEntity.notFound().build(); // Return 404 if no students are found
        } else {
            return ResponseEntity.ok(students); // Return 200 with the list of students
        }
    }

    //Getting the Data by Starting letter
    @GetMapping("/prefix/{prefix}")
    public ResponseEntity<List<Student>> getStudentsByNamePrefix(@PathVariable String prefix) {
        List<Student> students = studentService.getStudentsByNamePrefix(prefix);

        System.out.println(students);
        if (students.isEmpty()) {
           // return ResponseEntity.notFound().build(); // Return 404 if no students found
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.ok(students); // Return 200 with the list of students
           // return ResponseEntity.ok(Optional.of(students));
        }
    }



    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Student> delete(@PathVariable("id") long id) {
        Optional<Student> student = studentService.deleteById(id);

        System.out.println(student);
        return student.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/deleteList")
    public ResponseEntity<Void> delete(@RequestBody List<Long> ids) {
        boolean allDeleted = studentService.deleteByIds(ids);

        System.out.println(allDeleted);
        if (allDeleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(404).build();
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Student> update(@PathVariable("id") long id, @RequestBody Student updateStudent) {
        Optional<Student> student = studentService.updateById(id, updateStudent);
        System.out.println(student);
        if (student.isPresent()) {
            return ResponseEntity.ok(student.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/updateList")
    public ResponseEntity<List<Student>> updateList(@RequestBody List<Student> students) {
        List<Student> updatedStudents = studentService.updateStudents(students);
        System.out.println(updatedStudents);
        return ResponseEntity.ok(updatedStudents);
    }

}
