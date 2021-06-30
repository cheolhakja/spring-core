package hongik.corestudy100.order;

import hongik.corestudy100.discount.RateDiscountPolicy;
import hongik.corestudy100.member.Grade;
import hongik.corestudy100.member.Member;
import hongik.corestudy100.member.MemberRepository;
import hongik.corestudy100.member.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class OrderServiceImplTest {
    // 의존관계 생성자 주입을 선택했을때는 스프링 없이 순수 자바로 테스트 코드를 만들때 장점이 있다 - 의존관계 파악이 용이하다

    @Test
    void createOrder(){
        MemberRepository memberRepository = new MemoryMemberRepository();
        Member member = new Member(1L, "name", Grade.VIP);
        memberRepository.save(member);
        OrderService orderService = new OrderServiceImpl(new MemoryMemberRepository(), new RateDiscountPolicy()); //이부분에서 수정자 주입보다 생성자 주입이 낫다
        Order order = orderService.createOrder(1l, "item", 10000);
        assertThat(order.getDiscountPrice()).isEqualTo(1000);

    }

}