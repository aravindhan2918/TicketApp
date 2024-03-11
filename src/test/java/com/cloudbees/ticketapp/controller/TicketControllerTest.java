package com.cloudbees.ticketapp.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.cloudbees.ticketapp.controller.TicketController;
import com.cloudbees.ticketapp.domain.Ticket;
import com.cloudbees.ticketapp.service.TicketService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
public class TicketControllerTest {

    @Mock
    private TicketService ticketService;

    @InjectMocks
    private TicketController ticketController;

    @Test
    public void testPurchaseTicket() {
        Ticket ticket = new Ticket("London", "France", "John", "Doe", 5.0, "A");
        when(ticketService.createTicket(any())).thenReturn(ticket);
        ResponseEntity<String> response = ticketController.purchaseTicket(ticket);

        assertEquals("Ticket purchased successfully, Ticket Id: 0", response.getBody());
    }

    @Test
    public void testGetAllTickets() {
        List<Ticket> tickets = new ArrayList<>();
        tickets.add(new Ticket("London", "France", "John", "Doe", 5.0, "A"));
        tickets.add(new Ticket("Paris", "Berlin", "Jane", "Smith", 6.0, "B"));
        when(ticketService.getAllPassengers()).thenReturn(tickets);

        ResponseEntity<List<Ticket>> response = ticketController.getAllTickets();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(2, response.getBody().size());
    }

    @Test
    public void testGetTicketDetails() {
        Ticket ticket = new Ticket("London", "France", "John", "Doe", 5.0, "A");
        when(ticketService.getPassengerById(anyLong())).thenReturn(Optional.of(ticket));

        ResponseEntity<Optional<Ticket>> response = ticketController.getTicketDetails(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(ticket, response.getBody().get());
    }

    @Test
    void getUsersBySectionTest() {
        List<Ticket> tickets = new ArrayList<>();
        tickets.add(new Ticket("London", "France", "John", "Doe", 5.0, "A"));
        tickets.add(new Ticket("Paris", "Berlin", "Jane", "Doe", 8.0, "B"));

        when(ticketService.fetchPassengerSection(anyString())).thenReturn(tickets);

        ResponseEntity<List<Ticket>> response = ticketController.getUsersBySection("A");

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(response.getBody().size() > 0);
        assertEquals("John", response.getBody().get(0).getFirstName());
    }

    @Test
    void removeTicketTest() {
        // Mocking ticket ID
        long ticketId = 1L;

        ResponseEntity<String> response = ticketController.removeTicket(ticketId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Ticket removed successfully.", response.getBody());
    }

    @Test
    void modifySeatTest() {
        long ticketId = 1L;
        Ticket ticket = new Ticket("London", "Paris", "John", "Doe", 10.0, "A");

        when(ticketService.updatePassengerSeat(anyLong(), any())).thenReturn(ticket);

        ResponseEntity<String> response = ticketController.modifySeat(ticketId, ticket);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Seat modified successfully.", response.getBody());
    }
}
