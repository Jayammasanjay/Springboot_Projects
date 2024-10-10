package com.example.student.Repository;

import com.example.student.entity.Teachers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface teachersRepository extends JpaRepository<Teachers, Long> {

}
