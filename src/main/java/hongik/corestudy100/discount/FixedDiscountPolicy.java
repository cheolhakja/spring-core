package hongik.corestudy100.discount;

import hongik.corestudy100.member.Grade;
import hongik.corestudy100.member.Member;

public class FixedDiscountPolicy implements DiscountPolicy{

    private static int discountFixAmount = 1000;
    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            return discountFixAmount;
        }else{
            return 0;
        }
    }
}
