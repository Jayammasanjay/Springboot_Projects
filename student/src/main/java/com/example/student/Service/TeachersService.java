package com.example.student.Service;

import com.example.student.Repository.teachersRepository;
import com.example.student.entity.Teachers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeachersService {

    @Autowired
    private teachersRepository teachersRepository;

    //adding single Data
    public Teachers add(Teachers teachers){
        return teachersRepository.save(teachers);
    }
    //Adding list of Data
    public List<Teachers> addList(List<Teachers> teachers){
        return teachersRepository.saveAll(teachers);
    }

    //Getting a single Data by Id
    public Optional<Teachers> getById(long id){
        return teachersRepository.findById(id);
    }


    //getting data by Name
    public ResponseEntity<Teachers> getTeacherByName(String teacherName) {
        Teachers teacher= teachersRepository.findByTeacherName(teacherName);
        if (teacher!=null){
            return ResponseEntity.ok(teacher);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    //Delete a Data By Id

    public Optional<Teachers> deleteById(long id){
        Optional<Teachers> teacher=teachersRepository.findById(id);
        if(teacher.isPresent()){
            teachersRepository.delete(teacher.get());
            return teacher;
        }else {
            return Optional.empty();
        }
    }

    public List<Teachers> listOfData(){
        return teachersRepository.findAll();

    }
}
