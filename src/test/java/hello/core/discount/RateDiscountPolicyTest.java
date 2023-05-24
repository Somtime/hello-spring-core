package hello.core.discount;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


class RateDiscountPolicyTest {
    DiscountPolicy discountPolicy;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        discountPolicy = appConfig.discountPolicy();
    }

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 함")
    void vip_discount() {
        // given
        Member member = new Member(1L, "member", Grade.VIP);

        // when
        int discount = discountPolicy.discount(member, 20000);

        // then
        assertThat(discount).isEqualTo(2000);
    }

    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않아야 함")
    void basic_discount() {
        // given
        Member member = new Member(1L, "member", Grade.BASIC);

        // when
        int discount = discountPolicy.discount(member, 20000);

        // then
        assertThat(discount).isEqualTo(0);
    }
}