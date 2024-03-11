package com.cloudbees.ticketapp.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "ticket_details")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "departure_from")
    private String departureFrom;

    @Column(name = "destination")
    private String destination;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "price_paid")
    private double pricePaid;

    @Column(name = "seat_section")
    private String seatSection;

    public Ticket(String departureFrom, String destination, String firstName,String lastName, double pricePaid, String seatSection) {
        this.departureFrom = departureFrom;
        this.destination = destination;
        this.firstName = firstName;
        this.lastName = lastName;
        this.pricePaid = pricePaid;
        this.seatSection = seatSection;
    }

    public Ticket() {
        // TODO Auto-generated constructor stub
    }

    public String getDepartureFrom() {
        return departureFrom;
    }

    public void setDepartureFrom(String departureFrom) {
        this.departureFrom = departureFrom;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getPricePaid() {
        return pricePaid;
    }

    public void setPricePaid(double pricePaid) {
        this.pricePaid = pricePaid;
    }

    public String getSeatSection() {
        return seatSection;
    }

    public void setSeatSection(String seatSection) {
        this.seatSection = seatSection;
    }

    public long getId() {
        return id;
    }

    public void setId(long Id) {
        this.id = Id;
    }
}