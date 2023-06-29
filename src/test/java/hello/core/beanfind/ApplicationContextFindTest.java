package hello.core.beanfind;


import hello.core.AppConfig;
import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class ApplicationContextFindTest {
    AnnotationConfigApplicationContext ac= new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findByName(){
        DiscountPolicy discountPolicy = ac.getBean("discountPolicy", DiscountPolicy.class);
        assertThat(discountPolicy).isInstanceOf(RateDiscountPolicy.class);

    }


    @Test
    @DisplayName("타입으로 조회")
    void findByType(){
        DiscountPolicy discountPolicy = ac.getBean(DiscountPolicy.class);
        assertThat(discountPolicy).isInstanceOf(RateDiscountPolicy.class);
    }

    @Test
    @DisplayName("구현체 로 조회")
    void findByName2(){
        RateDiscountPolicy discountPolicy = ac.getBean("discountPolicy", RateDiscountPolicy.class);
        assertThat(discountPolicy).isInstanceOf(RateDiscountPolicy.class);
    }


    @Test
    @DisplayName("빈 조회 실패")
    void findByNameX(){


        org.junit.jupiter.api.Assertions.assertThrows(NoSuchBeanDefinitionException.class,
                () ->ac.getBean("xx", RateDiscountPolicy.class)
        );
    }

}
