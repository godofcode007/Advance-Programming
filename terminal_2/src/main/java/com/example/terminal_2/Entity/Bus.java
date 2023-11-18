package com.example.terminal_2.Entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "bus")
public class Bus {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column
    String Model;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "bus")
    List<Passenger> passengers;

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public List<Passenger> setPassengers(List<Passenger> passengers) {
        return this.passengers = passengers;
    }

    public void addPassenger(Passenger p) {
        passengers.add(p);
    }

    public Bus(String model) {
        this.Model = model;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public Bus() {
    }

}
