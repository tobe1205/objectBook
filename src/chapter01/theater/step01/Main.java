package chapter01.theater.step01;

public class Main {
    public static void main(String[] args) {

        //티켓 생성
        Ticket ticket1 = new Ticket();
        Ticket ticket2 = new Ticket();
        //매표소 생성
        TicketOffice ticketOffice = new TicketOffice(100L, ticket1, ticket2);
        //판매원 생성
        TicketSeller ticketSeller = new TicketSeller(ticketOffice);

        //초대권이 있는 관람객을 생성 후 극장 입장
        Bag hasInvitationBag = new Bag(new Invitation(), 0L);
        Audience audience = new Audience(hasInvitationBag);
        Theater theater = new Theater(ticketSeller);
        theater.enter(audience);
        System.out.println("표를 가지고있는관객 : "+ theater);

        //초대권이 없는 경우
        Bag dontHaveInvitationBag = new Bag(100L);
        Audience noAudience = new Audience(dontHaveInvitationBag);
        theater.enter(noAudience);
        ticketSeller.getTicketOffice().plusAmount(100L);
        System.out.println("표를 가지고 있지 않는 관객 : " + theater);
    }
}
