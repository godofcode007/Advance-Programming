package com.example.terminal_2.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.terminal_2.Entity.Bus;
import com.example.terminal_2.Entity.Passenger;
import com.example.terminal_2.Repository.BusRepository;
import com.example.terminal_2.Repository.PassengerRepository;

@Service
public class TerminalService {

    @Autowired
    BusRepository busRep;

    @Autowired
    PassengerRepository passRep;

    public void saveBus(Bus b) {
        busRep.save(b);
    }

    public void savePassenger(Passenger p) {
        passRep.save(p);
    }

    public List<Bus> getBuses() {
        return busRep.findAll();
    }

    public Optional<Bus> getBusById(Long id) {
        return busRep.findById(id);
    }

    public List<Passenger> getPassengers() {
        return passRep.findAll();
    }
}
