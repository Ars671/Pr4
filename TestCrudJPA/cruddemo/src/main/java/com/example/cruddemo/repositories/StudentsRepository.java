package com.example.cruddemo.repositories;

import com.example.cruddemo.models.Students;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentsRepository extends JpaRepository<Students, Long> {
    
    ///List<Students> findByPostname(String postname);
    
}
