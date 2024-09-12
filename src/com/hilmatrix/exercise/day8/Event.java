package com.hilmatrix.exercise.day8;

import java.util.ArrayList;
import java.util.List;

public class Event {
    private String eventName;
    private int ticketPrice;
    private int ticketMax;
    private int ticketSold;
    private List<Ticket> ticketList;

    public String getEventName() {
        return eventName;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

    public int getTicketAvailable() {
        return ticketMax - ticketSold;
    }

    public boolean isTicketAvailable() {
        return (ticketMax - ticketSold) > 0;
    }

    public Event(String eventName, int ticketPrice, int ticketMax) {
        this.eventName = eventName;
        this.ticketPrice = ticketPrice;
        this.ticketMax = ticketMax;
        ticketList = new ArrayList<>();
    }

    public Ticket bookTicket(String userName) {
        if (ticketSold < ticketMax) {
            try {
                Ticket ticket = new Ticket(eventName, userName, ticketPrice);
                ticketSold++;
                ticketList.add(ticket);
                System.out.println("Booked successfully !");
                return ticket;
            } catch (Exception e) {
                System.out.println("Error creating ticket");
                return null;
            }
        } else {
            System.out.println("Ticket not available");
            return null;
        }
    }
}
