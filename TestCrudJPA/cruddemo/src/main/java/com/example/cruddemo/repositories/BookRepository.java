package com.example.cruddemo.repositories;

import com.example.cruddemo.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    
    Book findByBookname (String bookname);
    
}
