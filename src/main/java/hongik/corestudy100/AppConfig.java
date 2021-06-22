package hongik.corestudy100;

import hongik.corestudy100.discount.DiscountPolicy;
import hongik.corestudy100.discount.FixedDiscountPolicy;
import hongik.corestudy100.discount.RateDiscountPolicy;
import hongik.corestudy100.member.MemberRepository;
import hongik.corestudy100.member.MemberService;
import hongik.corestudy100.member.MemberServiceImpl;
import hongik.corestudy100.member.MemoryMemberRepository;
import hongik.corestudy100.order.OrderService;
import hongik.corestudy100.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(
                memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }

}
