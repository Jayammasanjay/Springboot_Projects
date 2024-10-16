package com.example.student.Service;

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



    //adding a list of data
    public boolean addData(List<Student> students) {
        try {
            repository.saveAll(students);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    //adding single Data
    public boolean add(Student student) {
        try {
            repository.save(student); // Save the student
            return true; // Return true if save is successful
        } catch (Exception e) {

            return false; // Return false if there's an exception
        }
    }
    //Finding the data by Name

    public List<Student> getByName(String studentName){
        List<Student> student=repository.findByStudentName(studentName);
        return student;
    }

    //finding by starting letter
    public List<Student> getStudentsByNamePrefix(String prefix) {
        return repository.findByStudentNameStartingWith(prefix);
    }




    //Getting a list of Data
    public List<Student> get(){
        return repository.findAll();
    }


    //Getting data by Id
    public Optional<Student> getById(long id){

        try {
            return repository.findById(id);
        }catch (Exception e){
            e.printStackTrace();
            return Optional.empty();
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

    public boolean deleteByIds(List<Long> ids) {
        List<Student> students = repository.findAllById(ids);
        
        if (students.size() != ids.size()) {
            return false; // Not all IDs were found
        }
        
        repository.deleteAll(students);
        return true;
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

    
    public List<Student> updateStudents(List<Student> students) {
        return repository.saveAll(students);
    }

}
