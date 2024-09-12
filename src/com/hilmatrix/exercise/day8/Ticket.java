package com.hilmatrix.exercise.day8;
import java.util.UUID;

public class Ticket implements Ticketable {
    private static int soldTickets;

    private String id;
    private final String eventName;
    private final String userName;
    private int price;
    public boolean confirmed;

    public Ticket(String eventName, String userName, int price) {
        this.eventName = eventName;
        this.userName = userName;
        this.price = price;
        this.id = UUID.randomUUID().toString();
        this.confirmed = false;
        soldTickets++;
    }

    @Override
    public String printTicket() {
        String result = "";
        result += "Ticked ID = " + id + "\n";
        result += "Event Name = " + eventName + "\n";
        result += "Price = " + price + "\n";
        return result;
    }
}
