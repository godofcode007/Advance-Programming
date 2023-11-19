package com.example.doctor.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;
    String surname;
    Long office_no;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public Long getOffice_no() {
        return office_no;
    }
    public void setOffice_no(Long office_no) {
        this.office_no = office_no;
    }
    public Doctor(String name, String surname, Long office_no) {
        this.name = name;
        this.surname = surname;
        this.office_no = office_no;
    }
    public Doctor() {
    }


}
