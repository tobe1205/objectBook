package chapter01.theater.step03;

public class Audience {

    //소지품을 보관하기 위해 가방 소지
    private Bag bag;

    public Audience(Bag bag){
        this.bag = bag;
    }

    public Long buy(Ticket ticket) {
        return bag.hold(ticket);

    }
}
