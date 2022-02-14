package chapter02.movie.step01.pricing;

import chapter02.movie.step01.DiscountCondition;
import chapter02.movie.step01.Screening;

public class SequenceCondition implements DiscountCondition {

    private int sequence; //할인 여부를 판단하기 위해 사용할 순번

    public SequenceCondition(int sequence) {
        this.sequence = sequence;
    }

    /**
     *
     * @param screening 상영정보
     * @return 파라미터로 전달된 Screening의 상영 순번과 일치할 경우 true 반환, 아닐시 false 반환
     */
    @Override
    public boolean isSatisfiedBy(Screening screening) {
        return screening.isSequence(sequence);
    }
}
