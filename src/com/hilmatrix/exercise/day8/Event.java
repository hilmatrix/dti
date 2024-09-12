package com.hilmatrix.exercise.day8;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Event {
    private String eventName;
    private String id;
    private int ticketPrice;
    private int ticketMax;
    private int ticketSold;
    private List<String> ticketIDList;

    public String getID() {
        return id;
    }
    public void removeTicket(String ticketId) {
        ticketIDList.remove(ticketId);
        ticketSold--;
    }

    public void addTicket(String ticketId) {
        ticketIDList.add(ticketId);
        ticketSold++;
    }

    public int getTicketMax() {
        return ticketMax;
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

    public Event(String eventId, String eventName, int ticketPrice, int ticketMax) {
        this.id = eventId;
        this.eventName = eventName;
        this.ticketPrice = ticketPrice;
        this.ticketMax = ticketMax;
        ticketIDList = new ArrayList<>();
    }
}
