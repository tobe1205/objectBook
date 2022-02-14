package chapter01.theater.step03;

public class Theater {

    private TicketSeller ticketSeller;

    public Theater(TicketSeller ticketSeller) {
        this.ticketSeller = ticketSeller;
    }

    //극장 입장 메서드드
    public void enter(Audience audience){
        ticketSeller.sellTo(audience);
    }
}
