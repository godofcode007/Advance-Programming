package com.example.terminal21.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.terminal21.Entity.Passenger;
import com.example.terminal21.Repository.BusRepository;
// import com.example.terminal21.Entity.Passenger;
import com.example.terminal21.Repository.PassengerRepository;

@Service
public class passengerService {
    
    @Autowired
    PassengerRepository passRep;

    @Autowired
    BusRepository busRep;

    public void savePassenger(Passenger p){
        passRep.save(p);
    }

    public List<Passenger> getPassenger(Long busId){
        return passRep.findByBusId(busId);
    }

    public void savePassenger(Passenger p, Long busId){
        p.setBus(busRep.findById(busId).get());
        passRep.save(p);
    }

}
