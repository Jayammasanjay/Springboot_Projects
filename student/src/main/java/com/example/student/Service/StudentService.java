package com.example.student.Service;

import com.example.student.Repository.StudentRepository;
import com.example.student.entity.Student;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;



    public Map<Long, Student> studentMap = new LinkedHashMap<>();


    //Getting all data
    public Map<Long, Student> getAllStudentsAsMap() {
        List<Student> students = repository.findAll();
        // Iterate over the list of students and populate the map
        for (Student student : students) {
            studentMap.put(student.getStudentRollNo(), student);
        }

        return studentMap;
    }

//    Getting student data by Id
//    public Student getByIdMap(long id) {
//         studentMap = getAllStudentsAsMap();
//        return studentMap.get(id);
//    }


    //Getting student data BY Name
    public Student getByNameMap(String name) {
         studentMap = getAllStudentsAsMap();  // Retrieve the map of students

        // Iterate through the values of the map to find the student by name
        for (Student student : studentMap.values()) {
            if (student.getStudentName().equalsIgnoreCase(name)) {
                System.out.println(student);
                return student;
            }
        }

        return null;
    }

    public Student updateByName(String name,Student updatedStudentDetails){
        Map<Long,Student> update=getAllStudentsAsMap();

        for(Student upd:update.values()){
            if(upd.getStudentName().equalsIgnoreCase(name)){
                upd.setStudentName(updatedStudentDetails.getStudentName());
                upd.setStudentClass(updatedStudentDetails.getStudentClass());
            }
            repository.save(upd);
            return upd;
        }
        return null;
    }




//-----------------------------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------

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
            // Log the exception if needed
            return false; // Return false if there's an exception
        }
    }



    //Getting a list of Data
    public List<Student> get(){
        return repository.findAll();
    }


    //getting single student data by id
    public Optional<Student> getById(long id){
        return repository.findById(id);
    }


    //Delete student data by id
    public Optional<Student> deleteById(long id){
        Optional<Student> student=repository.findById(id);
        if(student.isPresent()){
            repository.delete(student.get());
            return student;
        }else {
            throw new EntityNotFoundException("Id Not Found");
        }
    }

    //Deleting list of studentData By id
    public boolean deleteByIds(List<Long> ids) {
        List<Student> students = repository.findAllById(ids);
        
        if (students.size() != ids.size()) {
            return false; // Not all IDs were found
        }
        
        repository.deleteAll(students);
        return true;
    }

    //Updating student data using ID
    public Optional<Student> updateById(long id, Student updatedStudent) {
        Optional<Student> student = repository.findById(id);
        //if present pass the data to existingStudent
        if (student.isPresent()) {
            Student existingStudent = student.get();


            existingStudent.setStudentName(updatedStudent.getStudentName());
            existingStudent.setStudentClass(updatedStudent.getStudentClass());

            repository.save(existingStudent);


            return Optional.of(existingStudent);
        } else {
            throw  new RuntimeException("Id Not Found"+id);
        }
    }


    //updating list of student at once
    public List<Student> updateStudents(List<Student> students) {

        return repository.saveAll(students);
    }


    //Getting a list of student at once
    public List<Student> getByName(String studentName) {
        return repository.findByStudentName(studentName);

    }

    //Getting a list of student with starting of there letter
    public List<Student> getStudentsByNamePrefix(String prefix) {
        return repository.findByStudentNameStartingWith(prefix);

    }
}
