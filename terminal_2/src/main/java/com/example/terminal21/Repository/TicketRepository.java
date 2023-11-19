package com.example.terminal21.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.terminal21.Entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

}
