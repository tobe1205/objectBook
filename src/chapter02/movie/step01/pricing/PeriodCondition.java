package chapter02.movie.step01.pricing;

import chapter02.movie.step01.DiscountCondition;
import chapter02.movie.step01.Screening;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class PeriodCondition implements DiscountCondition {
    private DayOfWeek dayOfWeek; //요일
    private LocalTime startTime; //시작 시간
    private LocalTime endTime; //종료 시간

    public PeriodCondition(DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime) {
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    /**
     * 상영 시작 시간이 특정한 기간 안에 포함되는지 여부 판단 할인 여부 결정
     * @param screening
     * @return Screening의 상영 요일이 dayOfWeek와 같고, 상영 시작 기간이
     * startTime과 endTime 사이에 있을 경우 true 반환, 아닐 시에는 false 반환
     */
    @Override
    public boolean isSatisfiedBy(Screening screening) {
        return screening.getStartTime().getDayOfWeek().equals(dayOfWeek)
                && startTime.compareTo(screening.getStartTime().toLocalTime()) <= 0
                && endTime.compareTo(screening.getStartTime().toLocalTime()) >= 0;
    }
}
