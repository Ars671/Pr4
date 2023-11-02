package com.example.cruddemo.repositories;

import com.example.cruddemo.models.Seasonticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeasonticketRepository extends JpaRepository<Seasonticket, Long> {
    
    Seasonticket findBySeasonticketnumber(String seasonticketnumber);
    
}
