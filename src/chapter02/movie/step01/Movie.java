package chapter02.movie.step01;

import chapter02.money.Money;

import java.time.Duration;

public class Movie {
    private String title; //영화제목
    private Duration runningTime;  //상영시간
    private Money fee; //영화요금
    private DiscountPolicy discountPolicy; //할인정책

    public Movie(String title, Duration runningTime, Money fee, DiscountPolicy discountPolicy) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        this.discountPolicy = discountPolicy;
    }

    public Money getFee(){
        return fee;
    }

    public Money calculateMovieFee(Screening screening){
        return fee.minus(discountPolicy.calculateDiscountAmount(screening));
    }
}
