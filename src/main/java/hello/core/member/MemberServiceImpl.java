package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{

    //private final MemberRepository memberRepository = new MemoryMemberRepository(); //구현체를 의존하고 있음 , DIP 위반
    private final MemberRepository memberRepository;  //인터페이스만 존재

    @Autowired          //생성자에 자동 의존관계 주입 설정
    public MemberServiceImpl(MemberRepository memberRepository) {
        System.out.println("memberRepository : " + memberRepository);
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    //테스트용
    public MemberRepository getMemberRepository() {
        return this.memberRepository;
    }
}
