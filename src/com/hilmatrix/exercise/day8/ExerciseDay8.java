package com.hilmatrix.exercise.day8;

import java.util.List;
import java.util.Scanner;

public class ExerciseDay8 {

    public static void start() {
        Scanner scanner = new Scanner(System.in);
        Database.initialize();

        Database.addEvent("Festival Makanan",20000, 10);
        Database.addEvent("Konser Musik",50000, 6);
        Database.addEvent("Event Cosplay",100000, 3);

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
        List<String> eventList = Database.getEventList();
        System.out.println("-".repeat(30));

        for (int loop = 0; loop < eventList.size(); loop++) {
            Event event = Database.getEvent(loop);
            System.out.printf("%d. %s, available %d/%d, price %d\n",
                (loop + 1),
                event.getEventName(),
                event.getTicketAvailable(),
                event.getTicketMax(),
                event.getTicketPrice());
        }
    }

    public static void listPurchasedTickets() {
        List<String> ticketList = Database.getTicketList();
        System.out.println("-".repeat(30));


        for (int loop = 0; loop < ticketList.size(); loop++) {
            Ticket ticket = Database.getTicket(loop);
            Event event = Database.getEvent(ticket.getEventID());
            String printTicketOutput = ticket.printTicket();

            printTicketOutput = printTicketOutput.replace("EventID","Event Name");
            printTicketOutput = printTicketOutput.replace(event.getID(), event.getEventName());

            System.out.println((loop+1) + ". " + printTicketOutput);
        }
    }

    public static void ticketAction(Scanner scanner) {
        List<String> ticketList = Database.getTicketList();
        System.out.println("-".repeat(30));

        if (ticketList.isEmpty()) {
            return;
        }

        int selectedTicket = readInputRange(scanner, 1, ticketList.size());
        selectedTicket--;

        Ticket ticket = Database.getTicket(selectedTicket);

        System.out.println("-".repeat(30));
        if (ticket.isConfirmed()) {
            System.out.println("Ticket is confirmed");
        } else {
            confirmTicket(scanner, ticket);
        }
    }

    public static void confirmTicket(Scanner scanner, Ticket ticket) {
        System.out.println("Do you want to confirm ? 1) Yes 2) Cancel Ticket 3) Return to Menu");
        int confirmation = readInputRange(scanner, 1, 3);

        if (confirmation == 1) {
            ticket.setConfirmed(true);
        } else if (confirmation == 2) {
            Database.removeTicket(ticket.getId());
        }
    }

    public static void bookTicket(Scanner scanner) {
        List<String> eventList = Database.getEventList();
        System.out.println("-".repeat(30));

        System.out.println("Which event you want to book ?");
        int eventNumber = readInputRange(scanner, 1, eventList.size());
        eventNumber--;

        Event event = Database.getEvent(eventNumber);

        System.out.println("Ticket available : " + Database.getEvent(eventNumber).getTicketAvailable());
        if (!event.isTicketAvailable()) {
            System.out.println("Ticket is not available");
            return;
        }

        System.out.println("-".repeat(30));
        System.out.println("Please enter your name");
        Database.bookTicket(event.getID(), scanner.nextLine());
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
