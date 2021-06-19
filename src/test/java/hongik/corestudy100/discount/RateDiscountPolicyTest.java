package hongik.corestudy100.discount;

import hongik.corestudy100.member.Grade;
import hongik.corestudy100.member.Member;
import hongik.corestudy100.member.MemberService;
import hongik.corestudy100.member.MemberServiceImpl;
import hongik.corestudy100.order.Order;
import hongik.corestudy100.order.OrderService;
import hongik.corestudy100.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();
    @Test
    @DisplayName("비율 할인 정책 십프로 할인 그래서 천원 할인")
    void vip_o(){
        //given
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        //when
        int discount = rateDiscountPolicy.discount(member, 10000);
        //then
        Assertions.assertThat(discount).isEqualTo(1000);

    }

    @Test
    @DisplayName("vip 가 아니면 할인 엑스")
    void vip_x(){
        //given
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.BASIC);
        //when
        int discount = rateDiscountPolicy.discount(member, 10000);
        //then
        Assertions.assertThat(discount).isEqualTo(0);

    }

}