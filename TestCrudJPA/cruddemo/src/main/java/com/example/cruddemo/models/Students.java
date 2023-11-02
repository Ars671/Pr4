package com.example.cruddemo.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "studentss")

public class Students {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String studentsname;

    @OneToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name="creditbook_id")
    private Creditbook creditbook;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentsname() {
        return studentsname;
    }

    public void setStudentsname(String studentsname) {
        this.studentsname = studentsname;
    }

    public Creditbook getCreditbook() {
        return creditbook;
    }

    public void setCreditbook(Creditbook creditbook) {
        this.creditbook = creditbook;
    }

    public Students(String studentsname, Creditbook creditbook) {
        this.studentsname = studentsname;
        this.creditbook = creditbook;
    }

    public Students() {
    }
}
