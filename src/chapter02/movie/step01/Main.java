package chapter02.movie.step01;

import chapter02.money.Money;
import chapter02.movie.step01.pricing.AmountDiscountPolicy;
import chapter02.movie.step01.pricing.PercentDiscountPolicy;
import chapter02.movie.step01.pricing.PeriodCondition;
import chapter02.movie.step01.pricing.SequenceCondition;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        //고객정보
        Customer customer = new Customer();
        //1회차에 2000원 할인
        Movie aloneHomeMovie = new Movie("나홀로집에", Duration.ofMinutes(120), Money.wons(12000L),
                new AmountDiscountPolicy(Money.wons(2000L), new SequenceCondition(1)));

        //나홀로집에 1회차 상영정보
        Screening aloneHomeScreening_1 = new Screening(aloneHomeMovie, 1, LocalDateTime.now());
        Screening aloneHomeScreening_2 = new Screening(aloneHomeMovie, 2, LocalDateTime.now());

        Reservation aloneHomeReserve_1 = aloneHomeScreening_1.reserve(customer, 2);
        System.out.println("aloneHomeReserve_1 = " + aloneHomeReserve_1.toString()); // 20000원

        Reservation aloneHomeReserve_2 = aloneHomeScreening_2.reserve(customer, 2);
        System.out.println("aloneHomeReserve_2 = " + aloneHomeReserve_2); // 24000원

        Movie titanic = new Movie("타이타닉",
                Duration.ofMinutes(120),
                Money.wons(12000),
                new PercentDiscountPolicy(0.1,
                        new PeriodCondition(DayOfWeek.MONDAY,LocalTime.of(10,0),LocalTime.of(0,0)),
                        new SequenceCondition(2),
                        new PeriodCondition(DayOfWeek.MONDAY,LocalTime.of(23,0),LocalTime.of(23,59))));


        LocalDateTime discountDay = LocalDateTime.of(2022, 2, 14, 23, 31);

        LocalDateTime noDiscountDay = LocalDateTime.of(2022, 2, 15, 8, 0);

        Screening discountScreen = new Screening(titanic, 1, discountDay);
        Screening noDiscountScreen = new Screening(titanic, 1, noDiscountDay);

        Reservation discountReserve = discountScreen.reserve(customer, 2);
        Reservation noDiscountReserve = noDiscountScreen.reserve(customer, 2);

        System.out.println("discountReserve :: " + discountReserve); // 21600원
        System.out.println("noDiscountReserve :: " + noDiscountReserve); // 24000원


    }
}
