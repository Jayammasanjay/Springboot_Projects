package com.example.student.Service;

import com.example.student.Repository.SubjectRepository;
import com.example.student.entity.Subject;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    public Subject add(Subject subject){
        return subjectRepository.save(subject);
    }


    //deleting a subject by ID
    public Subject delete(long id) {
        // First find the subject by ID
        Optional<Subject> subject = subjectRepository.findById(id);

        if (subject.isPresent()) {
            // Delete the subject if found
            subjectRepository.deleteById(id);
            return subject.get(); // Return the deleted subject
        } else {
            // Handle the case when the subject is not found
            throw new EntityNotFoundException("Subject not found with id: " + id);
        }
    }



}