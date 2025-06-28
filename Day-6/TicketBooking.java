class TicketCounter {
    private int availableTickets = 5;

    public void bookTicket(String user, int numberOfTickets) {
        synchronized (this) {
            System.out.println(user + " is trying to book " + numberOfTickets + " ticket(s)...");

            if (numberOfTickets <= availableTickets) {
                System.out.println("Processing booking for " + user + "...");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Booking interrupted for " + user);
                }

                availableTickets -= numberOfTickets;
                System.out.println(" Booking successful for " + user + ". Tickets booked: " + numberOfTickets);
            } else {
                System.out.println(" Booking failed for " + user + ". Not enough tickets available.");
            }

            System.out.println(" Tickets remaining: " + availableTickets + "\n");
        }
    }
}

class BookingThread extends Thread {
    private TicketCounter counter;
    private String userName;
    private int ticketsToBook;

    public BookingThread(TicketCounter counter, String userName, int ticketsToBook) {
        this.counter = counter;
        this.userName = userName;
        this.ticketsToBook = ticketsToBook;
    }

    @Override
    public void run() {
        counter.bookTicket(userName, ticketsToBook);
    }
}

public class TicketBooking {
    public static void main(String[] args) {
        TicketCounter counter = new TicketCounter();

        BookingThread user1 = new BookingThread(counter, "Alice", 2);
        BookingThread user2 = new BookingThread(counter, "Bob", 2);
        BookingThread user3 = new BookingThread(counter, "Charlie", 2); 

        user1.start();
        user2.start();
        user3.start();
    }
}
