package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class singletonTest {

    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();
        MemberService memberService1 = appConfig.memberService();
        MemberService memberService2 = appConfig.memberService();

        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2); // 객체 생성이 비효율적 같은걸 게속....
        //요청을 할대마다 객체를 새로 생성한다.
        // 해결방안 : 객체가 딱 1개만 생성되고 , 그 객체를 공유하도록 설계하면 된다. -> 싱글톤
        Assertions.assertThat(memberService1).isNotSameAs(memberService2);


    }
}
