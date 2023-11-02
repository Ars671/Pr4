package com.example.cruddemo.controllers;

import com.example.cruddemo.models.Creditbook;
import com.example.cruddemo.models.Seasonticket;
import com.example.cruddemo.models.Book;
import com.example.cruddemo.models.Students;
import com.example.cruddemo.repositories.BookRepository;
import com.example.cruddemo.repositories.SeasonticketRepository;
import com.example.cruddemo.repositories.StudentsRepository;
import com.example.cruddemo.repositories.CreditbookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @Autowired
    private StudentsRepository studentsRepository;
    @Autowired
    private CreditbookRepository creditbookRepository;

    @GetMapping("/person1")
    public String Main1(Model model){
        Iterable<Creditbook> creditbook = creditbookRepository.findAll();
        model.addAttribute("creditbook", creditbook);
        return "person1";
    }

    @PostMapping("/person1/add")
    public String blogPostAdd1(@RequestParam String studentsname, @RequestParam String creditbooknumber, Model model)
    {
        System.out.println(studentsname);
        Creditbook creditbook = creditbookRepository.findByCreditbooknumber(creditbooknumber);
        System.out.println(creditbook.getId());
        Students students = new Students(studentsname, creditbook);
        studentsRepository.save(students);
        return "person1";
    }

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private SeasonticketRepository seasonticketRepository;

    @GetMapping("/person")
    private String Main(Model model){
        Iterable<Book> books = bookRepository.findAll();
        model.addAttribute("books", books);
        Iterable<Seasonticket> seasontickets = seasonticketRepository.findAll();
        model.addAttribute("seasontickets", seasontickets);

        return "person";
    }

    @PostMapping("/person/add")
    public String blogPostAdd(@RequestParam String book, @RequestParam String seasonticket, Model model)
    {
        Book book2 = bookRepository.findByBookname(book);
        Seasonticket seasonticket2 = seasonticketRepository.findBySeasonticketnumber(seasonticket);
        book2.getSeasonticket().add(seasonticket2);
        seasonticket2.getBooks().add(book2);
        bookRepository.save(book2);
        seasonticketRepository.save(seasonticket2);
        return "person";
    }
}
