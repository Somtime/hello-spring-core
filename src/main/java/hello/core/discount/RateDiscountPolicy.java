package hello.core.discount;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Qualifier("rateDiscountPolicy") // 생성자나 수정자 등록 시 @Qualifier 에 등록된 이름의 빈을 찾음
@MainDiscountPolicy
//@Primary
public class RateDiscountPolicy implements DiscountPolicy {
    private int discountPercent = 10;
    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) return (int) (price * discountPercent / 100);
        return 0;
    }
}
