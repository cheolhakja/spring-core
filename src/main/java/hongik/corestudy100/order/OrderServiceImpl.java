package hongik.corestudy100.order;

import hongik.corestudy100.discount.DiscountPolicy;
import hongik.corestudy100.discount.FixedDiscountPolicy;
import hongik.corestudy100.discount.RateDiscountPolicy;
import hongik.corestudy100.member.Member;
import hongik.corestudy100.member.MemberRepository;
import hongik.corestudy100.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository ;
    private final DiscountPolicy discountPolicy ;

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository,
                            DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice );

    }

    //테스트용 메서드
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }

    public DiscountPolicy getDiscountPolicy() {
        return discountPolicy;
    }
}
