package com.hilmatrix.exercise.day8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExerciseDay8 {
    public static List<Event> eventList = new ArrayList<>();

    public static void start() {
        Scanner scanner = new Scanner(System.in);
        eventList.add(new Event("Festival Makanan",20000, 15));
        eventList.add(new Event("Konser Musik",50000, 10));
        eventList.add(new Event("Event Cosplay",100000, 5));
        Ticket.initializeSoldTicketList();

        boolean quit = false;
        int input;

        while (!quit) {
            System.out.println("-".repeat(30));
            System.out.println("1. List Event, ticket available and price");
            System.out.println("2. Book ticket");
            System.out.println("3. List purchased tickets");
            System.out.println("4. Select ticket and action");
            System.out.println("0. Exit");

            input = readInputRange(scanner, 0, 4);

            switch (input) {
                case 0 : quit = true; break;
                case 1 : printEvents(); break;
                case 2 : bookTicket(scanner); break;
                case 3 : listPurchasedTickets(); break;
                case 4 : ticketAction(scanner); break;
            }
        }
    }

    public static void printEvents() {
        System.out.println("-".repeat(30));
        for (int loop = 0; loop < eventList.size(); loop++) {
            Event event = eventList.get(loop);
            System.out.println((loop+1) + ". " + event.getEventName() + ", " +" available "
                    + event.getTicketAvailable() + ", price " + event.getTicketPrice());
        }
    }

    public static void listPurchasedTickets() {
        System.out.println("-".repeat(30));
        List<Ticket> ticketList = Ticket.getSoldTicketList();
        for (int loop = 0; loop < ticketList.size(); loop++) {
            System.out.println((loop+1) + ". " + ticketList.get(loop).printTicket());
        }
    }

    public static void ticketAction(Scanner scanner) {
        List<Ticket> ticketList = Ticket.getSoldTicketList();
        System.out.println("-".repeat(30));

        if (ticketList.size() < 1) {
            return;
        }

        int selectedTicket = readInputRange(scanner, 1, ticketList.size());
        selectedTicket--;

        System.out.println("-".repeat(30));
        if (ticketList.get(selectedTicket).isConfirmed()) {
            System.out.println("Ticket is confirmed");
            return;
        } else {
            System.out.println("Do you want to confirm ? 1 Yes, 2 No 3 Cancel");
            int confirmation = readInputRange(scanner, 1, 3);

            if (confirmation == 1) {
                ticketList.get(selectedTicket).setConfirmed(true);
            } else if (confirmation == 2) {
                String ticketID = ticketList.get(selectedTicket).getId();
                String eventID = ticketList.get(selectedTicket).getEventID();
                ticketList.remove(selectedTicket);
                for (Event event : eventList) {
                    if (event.getEventID() == eventID)
                        event.removeTicket(ticketID);
                }
            }
        }
    }

    public static void bookTicket(Scanner scanner) {
        System.out.println("-".repeat(30));
        System.out.println("Which event you want to book ?");
        int eventNumber = readInputRange(scanner, 1, eventList.size());
        eventNumber--;

        System.out.println("Ticket available : " + eventList.get(eventNumber).getTicketAvailable());
        if (!eventList.get(eventNumber).isTicketAvailable()) {
            System.out.println("Ticket is not available");
            return;
        }

        System.out.println("-".repeat(30));
        System.out.println("Please enter your name");
        eventList.get(eventNumber).bookTicket(scanner.nextLine());
        System.out.println("-".repeat(30));
    }

    public static int readInputRange(Scanner scanner, int min, int max) {
        boolean correctInput = false;
        int result = min;

        while (!correctInput) {
            System.out.printf("Enter input between %d and %d : ", min, max);

            try {
                result = Integer.parseInt(scanner.nextLine());

                if ((result >= min) && (result <= max)) {
                    correctInput = true;
                } else {
                    System.out.println("Input outside of range");
                }
            } catch (Exception e) {
                System.out.println("Input parsing error");
            }
        }

        return result;
    }
}
