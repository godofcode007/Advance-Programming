package com.example.terminal21.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.terminal21.Entity.Bus;
// import com.example.terminal21.Entity.Passenger;
import com.example.terminal21.Repository.BusRepository;

@Service
public class busService {
    @Autowired
    BusRepository busRep;

    public void saveBus(Bus b) {
        busRep.save(b);
    }

    public List<Bus> getBuses() {
        return busRep.findAll();
    }

    public Optional<Bus> getBus(Long busId) {
        return busRep.findById(busId);
    }

}
