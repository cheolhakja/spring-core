package hongik.corestudy100.singleton;

import hongik.corestudy100.AppConfig;
import hongik.corestudy100.member.MemberService;
import hongik.corestudy100.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;


public class SingletonTest {
    @Test
    void pureContainer(){
        AppConfig appConfig = new AppConfig();
        MemberService memberService1 = appConfig.memberService();
        MemberService memberService2 = appConfig.memberService();
        Assertions.assertThat(memberService1).isNotSameAs(memberService2);

    }

    @Test
    void singletonServiceTest(){
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();
        assertThat(singletonService1).isSameAs(singletonService2);
        //same : 비교하려는 대상이 같은 것을 참조하는 지 비교함
        //equal : 비교하려는 대상의 내용(값)을 비교함
    }

    @Test
    @DisplayName("스프링 컨테이너에 있는 빈이 싱글톤인지 테스트")
    void springContainer(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService1 = ac.getBean("memberService", MemberServiceImpl.class);
        MemberService memberService2 = ac.getBean("memberService", MemberServiceImpl.class);

        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);
        assertThat(memberService1).isSameAs(memberService2);
    }
}
