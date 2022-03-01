package hello.core.member;

public class MemberServiceImpl implements MemberService {


    //커맨드 쉬프트 엔터 세미콜론까지
    //메모리 회원 저장소
    //AppConfig를 통해 DI 의존관계 주입.
    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
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
