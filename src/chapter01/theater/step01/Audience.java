package chapter01.theater.step01;

public class Audience {

    //소지품을 보관하기 위해 가방 소지
    private Bag bag;

    public Audience(Bag bag){
        this.bag = bag;
    }
    public Bag getBag(){
        return bag;
    }
}
