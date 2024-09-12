package com.hilmatrix.exercise.day8;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Ticket implements Ticketable {
    private final String id;
    private final String eventID;
    private final String userName;
    private int price;
    public boolean confirmed;

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public String getId() {
        return id;
    }

    public String getEventID() {
        return eventID;
    }

    public Ticket(String ticketID, String eventID, String userName, int price) {
        this.id = ticketID;
        this.eventID = eventID;
        this.userName = userName;
        this.price = price;
        this.confirmed = false;
    }

    @Override
    public String printTicket() {
        String result = "";
        result += "TicketID = " + id + ", ";
        result += "EventID = " + eventID + ", ";
        result += "Name = " + userName + ", ";
        result += "Price = " + price + ", ";
        result += "Confirmed = " + confirmed + "";
        return result;
    }
}
