package hongik.corestudy100.discount;

import hongik.corestudy100.member.Member;

public interface DiscountPolicy {
    public int discount(Member member, int price);
}
