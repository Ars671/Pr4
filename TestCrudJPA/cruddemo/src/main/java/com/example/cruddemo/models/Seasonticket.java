package com.example.cruddemo.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity

public class Seasonticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Name is required")

    private String seasonticketnumber;

    @ManyToMany
    @JoinTable (name="book_seasonticket",
            joinColumns=@JoinColumn (name="seasonticket_id"),
            inverseJoinColumns=@JoinColumn(name="book_id"))
    private List<Book> books;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSeasonticketnumber() {
        return seasonticketnumber;
    }

    public void setSeasonticketnumber(String seasonticketnumber) {
        this.seasonticketnumber = seasonticketnumber;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
