package hongik.corestudy100.Autowired;

import hongik.corestudy100.AutoAppConfig;
import hongik.corestudy100.discount.DiscountPolicy;
import hongik.corestudy100.member.Grade;
import hongik.corestudy100.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class AllBeanTest {
    @Test
    void findAllBean(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(DiscountService.class, AutoAppConfig.class);
        Member member = new Member(1L, "memberA", Grade.VIP);
        DiscountService discountService = ac.getBean(DiscountService.class);
        int finalPrice = discountService.discountTest(member, 10000, "rateDiscountPolicy" );

        assertThat(finalPrice).isEqualTo(1000);
    }
    
    static class DiscountService{
        private final Map<String, DiscountPolicy> policyMap;
        private final List<DiscountPolicy> policyList;

        @Autowired
        public DiscountService(Map<String, DiscountPolicy> policyMap, List<DiscountPolicy> policyList) {
            //의존관계 자동 주입 시 해당 타입의 '모든 빈'을 Map 또는 List로 받아올 수도 있다
            this.policyMap = policyMap;
            this.policyList = policyList;
        }
        
        public int discountTest(Member member, int price,String discountPolicyName){
            DiscountPolicy discountPolicy = policyMap.get(discountPolicyName);
            return discountPolicy.discount(member, price);
        }
    }
}
