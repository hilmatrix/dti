package com.hilmatrix.exercise.day8;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Event {
    private String eventName;
    private int ticketPrice;
    private int ticketMax;
    private int ticketSold;
    private List<String> ticketIDList;

    public String getEventID() {
        return eventID;
    }

    private String eventID;

    public void removeTicket(String ticketId) {
        ticketIDList.remove(ticketId);
        ticketSold--;
    }

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

        eventID = UUID.randomUUID().toString();
        ticketIDList = new ArrayList<>();
    }

    public Ticket bookTicket(String userName) {
        if (ticketSold < ticketMax) {
            try {
                Ticket ticket = new Ticket(eventName, eventID, userName, ticketPrice);
                ticketSold++;
                ticketIDList.add(ticket.getId());
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
