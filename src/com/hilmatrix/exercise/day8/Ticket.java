package com.hilmatrix.exercise.day8;

public class Ticket {
    private static int soldTickets;
    private int eventId;
    private String eventName;
    private int price;

    public static void setSoldTickets(int soldTickets) {
        Ticket.soldTickets = soldTickets;
    }

    public static int getSoldTickets() {
        return soldTickets;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
