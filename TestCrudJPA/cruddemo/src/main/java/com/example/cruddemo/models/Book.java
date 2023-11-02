package com.example.cruddemo.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;


@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String bookname;

    @ManyToMany
    @JoinTable (name="book_seasonticket",
            joinColumns=@JoinColumn (name="book_id"),
            inverseJoinColumns=@JoinColumn(name="seasonticket_id"))
    private List<Seasonticket> seasonticket;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public List<Seasonticket> getSeasonticket() {
        return seasonticket;
    }

    public void setSeasonticket(List<Seasonticket> seasonticket) {
        this.seasonticket = seasonticket;
    }
}
