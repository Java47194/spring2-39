package hello.core.order;

import hello.core.AppConfig;
import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import hello.core.member.Member;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {

    @Test//수정자 주입
    void createOrder(){


       MemoryMemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.save(new Member(1L,"name", Grade.VIP));
        OrderServiceImpl orderService=new OrderServiceImpl();
        orderService.setMemberRepository(new MemoryMemberRepository());
        orderService.setDiscountPolicy(new FixDiscountPolicy());
        Order order = orderService.createOrder(1L, "itemA", 20000);

        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);

    }


}