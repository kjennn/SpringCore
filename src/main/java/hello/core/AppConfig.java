package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixedDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemmoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {

    // AppConfig는 애플리케이션의 실제 동작에 필요한 "구현 객체를 생성" 한다.
    // 생성한 객체 인스턴스의 참조(래퍼런스)를 "생성자를 통해서 주입(연결), 인젝션" 해준다.
    // MemberServiceImpldms MemoryMemberRepository 를 의존하지 않는다.
    // 의존관계에 대한 고민은 외부에 맡기고 실행에만 집중할 수 있다.    => DIP 완성, 관심사 확실히 분리

    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository()); // 생성자 주입
    }

    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy()); // 생성자 주입
    }

    private MemmoryMemberRepository memberRepository() { // 역할이 드러나게 리팩토링 - 변경시 이 부분만 변경하면 됨
        return new MemmoryMemberRepository();
    }
    public DiscountPolicy discountPolicy(){
//        return new FixedDiscountPolicy();
        return new RateDiscountPolicy();
    }

}
