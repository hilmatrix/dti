package com.hilmatrix.exercise.day8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class Database {
    private static HashMap<String, Event> eventMap;
    private static HashMap<String, Ticket> ticketMap;

    private static List<String> eventList;
    private static List<String> ticketList;


    public static List<String> getEventList() {
        return eventList;
    }

    public static List<String> getTicketList() {
        return ticketList;
    }

    public static void initialize() {
        eventMap = new HashMap<>();
        eventList = new ArrayList<>();
        ticketMap = new HashMap<>();
        ticketList = new ArrayList<>();
    }

    public static Ticket newTicket(String eventID, String userName, int price) {
        String ticketID = UUID.randomUUID().toString();
        Ticket ticket = new Ticket(ticketID, eventID, userName, price);
        ticketMap.put(ticketID, ticket);
        ticketList.add(ticketID);
        return ticket;
    }

    public static void addEvent(String eventName, int ticketMax, int ticketPrice) {
        String eventID = UUID.randomUUID().toString();
        Event event = new Event(eventID, eventName, ticketMax, ticketPrice);
        eventMap.put(eventID, event);
        eventList.add(eventID);
    }

    public static Ticket getTicket(String ticketID) {
        return ticketMap.get(ticketID);
    }

    public static Ticket getTicket(int index) {
        return getTicket(ticketList.get(index));
    }

    public static Event getEvent(String eventID) {
        return eventMap.get(eventID);
    }

    public static Event getEvent(int index) {
        return getEvent(eventList.get(index));
    }

    public static void bookTicket(String eventID, String userName) {
        Event event = getEvent(eventID);

        if (event.isTicketAvailable()) {
            Ticket newTicket = newTicket(eventID, userName, event.getTicketPrice());
            event.addTicket(newTicket.getId());

            System.out.println("Booked successfully !");
        } else {
            System.out.println("Ticket not available");
        }
    }

    public static void removeTicket(String ticketID) {
        Ticket ticket = getTicket(ticketID);
        String eventID = ticket.getEventID();

        Event event = getEvent(eventID);
        event.removeTicket(ticketID);

        ticketMap.remove(ticketID);
        ticketList.remove(ticketID);
    }
}
