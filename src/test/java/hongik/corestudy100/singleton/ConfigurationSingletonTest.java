package hongik.corestudy100.singleton;

import hongik.corestudy100.AppConfig;
import hongik.corestudy100.member.MemberRepository;
import hongik.corestudy100.member.MemberService;
import hongik.corestudy100.member.MemberServiceImpl;
import hongik.corestudy100.order.OrderService;
import hongik.corestudy100.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationSingletonTest {
    @Test
    void configurationTest(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository1 = memberService.getMemberRepository();
        MemberRepository memberRepository2 = orderService.getMemberRepository();
        System.out.println(memberRepository1);
        System.out.println(memberRepository2);

        Assertions.assertThat(memberRepository1).isSameAs(memberRepository2);
    }

}
