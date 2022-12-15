package hello.core;

import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {

    MemberRepository memberRepository = new MemoryMemberRepository();

    //생성자를 통해서 구현체 주입
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository);
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository, new FixDiscountPolicy());
    }


}
