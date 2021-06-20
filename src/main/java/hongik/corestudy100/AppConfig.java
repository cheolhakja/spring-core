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

public class AppConfig {
    public MemberService memberService(){
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService(){
        return new OrderServiceImpl(
                new MemoryMemberRepository(), new FixedDiscountPolicy());
    }

}
