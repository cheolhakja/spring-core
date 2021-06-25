package hongik.corestudy100.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;


class StatelessServiceTest {

    @Test
    @DisplayName("싱글톤 일때 주의사항")
    void StatelessServiceSingleton(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatelessService statelessService1 = ac.getBean("statelessService", StatelessService.class);
        int priceA = statelessService1.order("nameA", 10000);
        int priceB = statelessService1.order("nameB", 20000);
        Assertions.assertThat(priceA).isEqualTo(10000);

    }

    static class TestConfig{
        @Bean
        public StatelessService statelessService(){
            return new StatelessService();
        }
    }
}