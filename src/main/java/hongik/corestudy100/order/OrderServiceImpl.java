package hongik.corestudy100.order;

import hongik.corestudy100.discount.DiscountPolicy;
import hongik.corestudy100.discount.FixedDiscountPolicy;
import hongik.corestudy100.discount.RateDiscountPolicy;
import hongik.corestudy100.member.Member;
import hongik.corestudy100.member.MemberRepository;
import hongik.corestudy100.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{
    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice );

    }
}
