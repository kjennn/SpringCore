package hello.core.member;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl();

    @Test
    void join(){
        //given 이런 조건에
        Member member = new Member(1L, "memberA", Grade.VIP);
        //when 이런 상황에
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then 이게나와야한다
        Assertions.assertSame(member,findMember);
    }
}
