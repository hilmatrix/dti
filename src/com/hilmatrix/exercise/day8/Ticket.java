package com.hilmatrix.exercise.day8;

public class Ticket implements Ticketable {
    private static int soldTickets;
    private static int uniqueTicketId;
    private final String eventName;
    private final String userName;
    private int price;

    public Ticket(String eventName, String userName) {
        this.eventName = eventName;
        this.userName = userName;
        soldTickets++;
    }

    @Override
    public String printTicket() {
        String result = "";
        result += "Ticked ID = " + uniqueTicketId;
        result += "Event Name = " + eventName;
        result += "Price = " + price;
        return result;
    }
}
