package chapter02.movie.step02.pricing;

import chapter02.money.Money;
import chapter02.movie.step02.DefaultDiscountPolicy;
import chapter02.movie.step02.DiscountCondition;
import chapter02.movie.step02.Screening;

public class PercentDiscountPolicy extends DefaultDiscountPolicy {
    private double percent;

    public PercentDiscountPolicy(double percent, DiscountCondition... conditions) {
        super(conditions);
        this.percent = percent;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return screening.getMovieFee().times(percent);
    }
}
