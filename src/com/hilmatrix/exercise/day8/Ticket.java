package com.hilmatrix.exercise.day8;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Ticket implements Ticketable {
    private static List<Ticket> soldTicketList;

    public static List<Ticket> getSoldTicketList() {
        return soldTicketList;
    }

    public static void initializeSoldTicketList() {
        soldTicketList = new ArrayList<>();
    }

    private String id;
    private final String eventName;
    private final String userName;
    private int price;
    public boolean confirmed;

    public String getEventID() {
        return eventID;
    }

    private final String eventID;

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public String getId() {
        return id;
    }

    public Ticket(String eventName, String eventID, String userName, int price) {
        this.eventName = eventName;
        this.userName = userName;
        this.price = price;
        this.id = UUID.randomUUID().toString();
        this.confirmed = false;

        this.eventID = eventID;
        soldTicketList.add(this);
    }

    @Override
    public String printTicket() {
        String result = "";
        result += "Ticked ID = " + id + ", ";
        result += "Event = " + eventName + ", ";
        result += "Name = " + userName + ", ";
        result += "Price = " + price + ", ";
        result += "Confirmed = " + confirmed + "";
        return result;
    }
}
