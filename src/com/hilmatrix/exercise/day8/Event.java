package com.hilmatrix.exercise.day8;

public class Event {
    private String eventName;
    private int ticketPrice;
    private int ticketMax;
    private int ticketSold;

    public Event(String eventName, int ticketPrice, int ticketMax) {
        this.eventName = eventName;
        this.ticketPrice = ticketPrice;
        this.ticketMax = ticketMax;
    }

    public Ticket bookTicket(String username) {
        if (ticketSold < ticketMax) {
            try {
                Ticket ticket = new Ticket(eventName, username);
                ticketSold++;
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
