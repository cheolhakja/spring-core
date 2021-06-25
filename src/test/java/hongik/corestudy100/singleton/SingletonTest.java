package hongik.corestudy100.singleton;

import hongik.corestudy100.AppConfig;
import hongik.corestudy100.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

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
}
