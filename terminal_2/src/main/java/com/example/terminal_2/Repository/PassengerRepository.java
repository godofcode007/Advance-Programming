package com.example.terminal_2.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.terminal_2.Entity.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {
    public List<Passenger> findByBusId(Long BusId);
}
