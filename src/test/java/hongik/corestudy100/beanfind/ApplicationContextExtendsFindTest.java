package hongik.corestudy100.beanfind;

import hongik.corestudy100.discount.DiscountPolicy;
import hongik.corestudy100.discount.FixedDiscountPolicy;
import hongik.corestudy100.discount.RateDiscountPolicy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class ApplicationContextExtendsFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfigTest.class);

    @Test
    @DisplayName("부모 타입으로 빈 조회시 ")
    void findBeanByParentTypeDuplicate(){
        //DiscountPolicy discountPolicy = ac.getBean(DiscountPolicy.class);
        assertThrows(NoUniqueBeanDefinitionException.class,
                () -> ac.getBean(DiscountPolicy.class));
    }

    @Test
    @DisplayName("부모 타입과 빈 이름으로 조회하기 ")
    void findBeanByParentTypeBeanName(){
        DiscountPolicy discountPolicy = ac.getBean( "rateDiscountPolicy", DiscountPolicy.class);
        assertThat(discountPolicy).isInstanceOf(RateDiscountPolicy.class);

    }

    @Test
    @DisplayName("하위타입으로 빈 조회하기 ")
    void findBeanBySubType(){
        //그리 좋은 방법은 아님. 구현체에 의존하기 때문이다.
        DiscountPolicy discountPolicy = ac.getBean( RateDiscountPolicy.class);
        assertThat(discountPolicy).isInstanceOf(RateDiscountPolicy.class);

    }

    @Test
    @DisplayName("부모타입으로 모든 빈 조회하기 ")
    void findAllBeanByParentType(){

        Map<String, DiscountPolicy> beansOfType = ac.getBeansOfType(DiscountPolicy.class);
        assertThat(beansOfType.size()).isEqualTo(2);

    }

    @Test
    @DisplayName("Object 타입으로 모든 빈 조회하기 ")
    void findAllBeanByObjectType(){

        Map<String, Object> beansOfType = ac.getBeansOfType(Object.class);
        for(String names : beansOfType.keySet()){
            System.out.println("keys = "+names+" values = " + beansOfType.get(names));
        }

    }

   @Configuration
   static class AppConfigTest{
       @Bean
       public DiscountPolicy fixedDiscountPolicy(){
           return new FixedDiscountPolicy();
       }

       @Bean
       public DiscountPolicy rateDiscountPolicy(){
           return new RateDiscountPolicy();
       }
   }

}
