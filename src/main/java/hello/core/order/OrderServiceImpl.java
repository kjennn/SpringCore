package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository ;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    //DIP 를 지키려면? - 관심사의 분리
     // private DiscountPolicy discountPolicy;

    @Override
    public Order createOrder(Long memerId, String itemName, int itemPrice) {
       Member member = memberRepository.findById(memerId);
       int discountPrices = discountPolicy.disCount(member,itemPrice);

       return new Order(memerId, itemName, itemPrice, discountPrices);
    }
}
