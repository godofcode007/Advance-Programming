package com.example.terminal_2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.terminal_2.Entity.Bus;

public interface BusRepository extends JpaRepository<Bus, Long> {

}