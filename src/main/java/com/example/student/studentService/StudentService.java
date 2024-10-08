package com.example.student.studentService;


import com.example.student.Repository.StudentRepository;
import com.example.student.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;



    public List<Student> addData(List<Student> student){

        return repository.saveAll(student);
    }

    public Student add(Student student){
        return repository.save(student);
    }

    public List<Student> get(){
        return repository.findAll();
    }


    public Optional<Student> getById(long id){
        return repository.findById(id);
    }


    public Optional<List<Student>> deleteListOfStudentsById(List<Long> studentRollNo) {
        List<Student> students = repository.findAllById(studentRollNo); // Fetch all students by IDs

        if (!students.isEmpty()) {
            repository.deleteAllById(studentRollNo); // Delete the students by their IDs
            return Optional.of(students);  // Return the list of deleted students
        } else {
            return Optional.empty(); // If no students found for the given IDs
        }
    }


    public Optional<Student> deleteById(long id){
        Optional<Student> student=repository.findById(id);
        if(student.isPresent()){
            repository.delete(student.get());
            return student;
        }else {
            return Optional.empty();
        }
    }

    public Optional<Student> updateById(long id, Student updatedStudent) {
        Optional<Student> student = repository.findById(id);

        if (student.isPresent()) {
            Student existingStudent = student.get();


            existingStudent.setStudentName(updatedStudent.getStudentName());
            existingStudent.setStudentClass(updatedStudent.getStudentClass());

            repository.save(existingStudent);


            return Optional.of(existingStudent);
        } else {

            return Optional.empty();
        }
    }

}
