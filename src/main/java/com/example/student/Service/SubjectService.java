package com.example.student.Service;

import com.example.student.Repository.SubjectRepository;
import com.example.student.entity.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    public Subject add(Subject subject){
        return subjectRepository.save(subject);
    }
}
