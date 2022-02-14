package chapter02.movie.step01;

import chapter02.money.Money;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class DiscountPolicy {
    private List<DiscountCondition> conditions = new ArrayList<>();

    public DiscountPolicy(DiscountCondition... conditions) {
        this.conditions = Arrays.asList(conditions);
    }

    //할인 조건을 만족하는 DiscountCondition이 하나라도 만족하는게 있으면 getDiscountAmount 호출해서 계산
    //만족하는 것이 없으면 0원 반환
    public Money calculateDiscountAmount(Screening screening) {
        for (DiscountCondition condition : conditions) {
            if (condition.isSatisfiedBy(screening)) {
                return getDiscountAmount(screening);
            }
        }
        return Money.ZERO;
    }
    //할인 요금 계산해 반환한다.
    abstract protected Money getDiscountAmount(Screening screening);
}
