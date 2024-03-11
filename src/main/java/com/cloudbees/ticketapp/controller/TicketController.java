package com.cloudbees.ticketapp.controller;

import com.cloudbees.ticketapp.domain.Ticket;
import com.cloudbees.ticketapp.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;
    /*
        To post the ticket details
    */
    @PostMapping("/purchase")
    public ResponseEntity<String> purchaseTicket(@RequestBody Ticket ticket) {
        Ticket savedTicket = ticketService.createTicket(ticket);
        return ResponseEntity.ok("Ticket purchased successfully, Ticket Id: "+savedTicket.getId());
    }

    /*
        To retrieve all ticket details
    */
    @GetMapping("/allTicketsdetails")
    public ResponseEntity<List<Ticket>> getAllTickets() {
        return ResponseEntity.ok(ticketService.getAllPassengers());
    }
    /*
         To retrieve the receipt detail based on Id.
    */
    @GetMapping("receipt/{ticketId}")
    public ResponseEntity<Optional<Ticket>> getTicketDetails(@PathVariable long ticketId) {
        Optional<Ticket> ticket= ticketService.getPassengerById(ticketId);
        if (ticket == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ticket);
    }

    /*
         To retrieve the Users  based on seat section.
    */
    @GetMapping("/users/{section}")
    public ResponseEntity<List<Ticket>> getUsersBySection(@PathVariable String section) {
        return ResponseEntity.ok(ticketService.fetchPassengerSection(section));
    }

    /*
        To delete the User  based on Ticket Id.
    */
    @DeleteMapping("/delete/{ticketId}")
    public ResponseEntity<String> removeTicket(@PathVariable long ticketId) {
        ticketService.deleteUserById(ticketId);
        return ResponseEntity.ok("Ticket removed successfully.");
    }

    /*
        To Update the User's seat section based on Ticket Id.
    */
    @PutMapping("/update/seat/{ticketId}")
    public ResponseEntity<String> modifySeat(@PathVariable long ticketId, @RequestBody Ticket ticket) {
        Ticket updatedTicket = ticketService.updatePassengerSeat(ticketId, ticket);
        if (updatedTicket != null) {
            return ResponseEntity.ok("Seat modified successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}