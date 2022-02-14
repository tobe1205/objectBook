package chapter01.theater.step03;

public class Main {

    public static void main(String[] args) {


        Ticket ticket1 = new Ticket();
        Ticket ticket2 = new Ticket();

        TicketOffice ticketOffice = new TicketOffice(0L, ticket1,ticket2);
        TicketSeller ticketSeller = new TicketSeller(ticketOffice);

        Theater theater = new Theater(ticketSeller);

        Bag bag = new Bag();
        Audience audience = new Audience(bag);

        audience.buy(ticket1);
        ticketSeller.sellTo(audience);

        theater.enter(audience);


    }
}
