package com.example.cruddemo.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "creditbooks")

public class Creditbook {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String creditbooknumber;
    @OneToOne(optional = true, mappedBy = "creditbook")
    private Students owner;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreditbooknumber() {
        return creditbooknumber;
    }

    public void setCreditbooknumber(String creditbooknumber) {
        this.creditbooknumber = creditbooknumber;
    }

    public Students getOwner() {
        return owner;
    }

    public void setOwner(Students owner) {
        this.owner = owner;
    }
}
