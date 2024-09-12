package com.hilmatrix.exercise.day8;

import java.util.ArrayList;
import java.util.List;

public class Event {
    private final String eventName;
    private final String id;
    private final int ticketPrice;
    private final int ticketMax;
    private final List<String> ticketIDList;

    public void removeTicket(String ticketId) { ticketIDList.remove(ticketId); }
    public void addTicket(String ticketId) { ticketIDList.add(ticketId); }

    public String getID() { return id; }
    public int getTicketMax() { return ticketMax; }
    public String getEventName() { return eventName; }
    public int getTicketPrice() { return ticketPrice; }
    public int getTicketAvailable() { return ticketMax - ticketIDList.size(); }
    public boolean isTicketAvailable() { return (ticketMax - ticketIDList.size()) > 0; }

    public Event(String eventId, String eventName, int ticketPrice, int ticketMax) {
        this.id = eventId;
        this.eventName = eventName;
        this.ticketPrice = ticketPrice;
        this.ticketMax = ticketMax;
        ticketIDList = new ArrayList<>();
    }
}
