package chapter02.movie.step01;

import chapter02.money.Money;

import java.time.LocalDateTime;

public class Screening {

    private Movie movie; //상영될 영화정보
    private int sequence; //상영 회차 정보
    private LocalDateTime whenScreened; //상영시작시간


    //상영
    public Screening(Movie movie, int sequence, LocalDateTime whenScreened) {
        this.movie = movie;
        this.sequence = sequence;
        this.whenScreened = whenScreened;
    }
    /**
     * 영화 시작 시간을 반환한다.
     * @return 영화 시작 시간
     */
    public LocalDateTime getStartTime(){
        return whenScreened;
    }

    /**
     * 인자로 들어온 회차와 같은지 판단한다.
     * @param sequence 회차 정보
     * @return 인자로 들어온 회차와 같은지 여부
     */
    public boolean isSequence(int sequence){
        return this.sequence == sequence;
    }

    /**
     * 상영되는 영화의 관람 가격을 반환한다.
     * @return 영화 관람 가격
     */
    public Money getMovieFee(){
        return movie.getFee();
    }

    /**
     * 상영 예약 정보를 만들어 반환한다.
     * @param customer 예약 고객정보
     * @param audienceCount 예약 인원수
     * @return 영화 예약 정보
     */
    public Reservation reserve(Customer customer,int audienceCount){
        return new Reservation(customer,this,calculateFee(audienceCount), audienceCount);
    }

    /**
     * 1인당 관람 비용을 구한 뒤 인원수대로 곱한 후 반한환다.
     * @param audienceCount 관람객 인원수
     * @return 총 관람 금액
     */
    private Money calculateFee(int audienceCount){
        return movie.calculateMovieFee(this).times(audienceCount);
    }
}


