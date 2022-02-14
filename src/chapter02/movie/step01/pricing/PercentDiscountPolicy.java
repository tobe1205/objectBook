package chapter02.movie.step01.pricing;

import chapter02.money.Money;
import chapter02.movie.step01.DiscountCondition;
import chapter02.movie.step01.DiscountPolicy;
import chapter02.movie.step01.Screening;

public class PercentDiscountPolicy extends DiscountPolicy {

    private double percent; //할인비율

    public PercentDiscountPolicy(double percent, DiscountCondition... conditions) {
        super(conditions);
        this.percent = percent;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return screening.getMovieFee().times(percent);
    }
}
