package chapter02.movie.step01;

import chapter02.money.Money;

public class Reservation {

    private Customer customer; //고객
    private Screening screening; //상영정보
    private Money fee; //예매 요금
    private int audienceCount; //인원 수

    public Reservation(Customer customer, Screening screening, Money fee, int audienceCount) {
        this.customer = customer;
        this.screening = screening;
        this.fee = fee;
        this.audienceCount = audienceCount;
    }
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Reservation{");
        sb.append("fee=").append(fee);
        sb.append(", audienceCount=").append(audienceCount);
        sb.append('}');
        return sb.toString();
    }
}
