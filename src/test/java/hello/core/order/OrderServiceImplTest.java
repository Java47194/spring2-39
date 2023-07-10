package hello.core.order;

import hello.core.AppConfig;
import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import hello.core.member.Member;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {

    @Test//수정자 주입
    void createOrder(){
        MemberRepository memberRepository=new MemoryMemberRepository();
        memberRepository.save(new Member(1L,"이용호",Grade.VIP));
        OrderServiceImpl orderService=new OrderServiceImpl(memberRepository, new FixDiscountPolicy());
        Order order = orderService.createOrder(1L, "itemA", 20000);
    }


}