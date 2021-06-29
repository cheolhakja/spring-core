package hongik.corestudy100.Autowired;

import hongik.corestudy100.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {
    @Test
    @DisplayName("스프링 빈이 없는 경우 옵션 처리")
    void noBeanTest(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }

    static class TestBean{
        //사용자가 만든 클래스 뿐만 아니라 설정정보 클래스도 빈으로 등록된다.
        //Member 객체는 빈으로 등록되있지 않는 상태이다

        @Autowired(required = false)
        public void setNoBean1(Member noBean1){
            System.out.println("noBean1 = " + noBean1);
            //빈이 없으면 호출 자체를 하지 않는다
        }

        @Autowired
        public void setNoBean2(@Nullable Member noBean2){
            System.out.println("noBean2 = " + noBean2);
            //@Nullable 이 있는 경우 빈이 없으면 널을 주입한다
        }

        @Autowired
        public void setNoBean3(Optional<Member> noBean3){
            System.out.println("noBean3 = " + noBean3);
            //null 또는 Member 객체를 갖는 클래스
            //toString() 호출, 값이 없으면 Optional.empty 라는 문자열 출력
        }
    }
}
