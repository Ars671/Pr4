package com.example.cruddemo.repositories;

import com.example.cruddemo.models.Creditbook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditbookRepository extends JpaRepository<Creditbook, Long> {

    Creditbook findByCreditbooknumber(String creditbooknumber);
    
}
