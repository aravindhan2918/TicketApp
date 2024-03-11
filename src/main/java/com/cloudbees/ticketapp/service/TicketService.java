package com.cloudbees.ticketapp.service;

import com.cloudbees.ticketapp.domain.Ticket;
import com.cloudbees.ticketapp.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    public Ticket createTicket(Ticket ticket){
        return ticketRepository.save(ticket);
    }

    public List<Ticket> getAllPassengers(){
        return ticketRepository.findAll();
    }

    public Optional<Ticket> getPassengerById(long id){
        return ticketRepository.findById(id);
    }

    public Ticket updatePassengerSeat(long id, Ticket newTicket){
        Ticket oldTicket = null;
        Optional<Ticket> optionalTicket = ticketRepository.findById(id);
        if(optionalTicket.isPresent()) {
            oldTicket = optionalTicket.get();
            oldTicket.setDepartureFrom(newTicket.getDepartureFrom());
            oldTicket.setDestination(newTicket.getDepartureFrom());
            oldTicket.setFirstName(newTicket.getFirstName());
            oldTicket.setLastName(newTicket.getLastName());
            oldTicket.setPricePaid(newTicket.getPricePaid());
            oldTicket.setSeatSection(newTicket.getSeatSection());
            ticketRepository.save(oldTicket);
        }else{
            return new Ticket();
        }
        return oldTicket;
    }

    public List<Ticket> fetchPassengerSection(String seatSection){
        List<Ticket> passengersInSection = ticketRepository.findBySeatSection(seatSection);
        return passengersInSection;
    }

    public void deleteUserById(long id){
        ticketRepository.deleteById(id);

    }

}


