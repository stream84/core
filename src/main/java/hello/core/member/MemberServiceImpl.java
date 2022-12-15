package hello.core.member;

public class MemberServiceImpl implements MemberService{

    //private final MemberRepository memberRepository = new MemoryMemberRepository(); //구현체를 의존하고 있음 , DIP 위반
    private final MemberRepository memberRepository;  //인터페이스만 존재

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
}
