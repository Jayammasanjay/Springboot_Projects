package com.example.student.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.student.entity.Subject;

import java.util.Optional;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
    Optional<Subject> findByName(String name);


}
