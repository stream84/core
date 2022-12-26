package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{

    //private final MemberRepository memberRepository = new MemoryMemberRepository();
    private MemberRepository memberRepository;
    private DiscountPolicy discountPolicy;

    @Autowired(required = false)
    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
        System.out.println("OrderServiceImpl.setDiscountPolicy");
        this.discountPolicy = discountPolicy;
    }
    @Autowired
    public void setMemberRepository(MemberRepository memberRepository) {
        System.out.println("OrderServiceImpl.setMemberRepository");
        this.memberRepository = memberRepository;
    }

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        System.out.println("OrderServiceImpl.OrderServiceImpl");
        System.out.println("memberRepository : " + memberRepository);
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //테스트 용
    public MemberRepository getMemberRepository() {
        return this.memberRepository;
    }
}
