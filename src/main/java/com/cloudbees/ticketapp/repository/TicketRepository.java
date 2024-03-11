package com.cloudbees.ticketapp.repository;

import java.util.List;

import com.cloudbees.ticketapp.domain.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    List<Ticket> findBySeatSection(String seatSection);

}


