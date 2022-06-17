package com.example.obspringdatajpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Coche {

    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String model;
    private String manufactura;
    private Long year;

    //contructor


    public Coche() {
    }

    public Coche(Long id, String model, String manufactura, Long year) {
        this.id = id;
        this.model = model;
        this.manufactura = manufactura;
        this.year = year;
    }

    //getter and setter


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufactura() {
        return manufactura;
    }

    public void setManufactura(String manufactura) {
        this.manufactura = manufactura;
    }

    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Coche{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", manufactura='" + manufactura + '\'' +
                ", year=" + year +
                '}';
    }
}
