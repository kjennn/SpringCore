package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixedDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemmoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemmoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixedDiscountPolicy();

    @Override
    public Order createOrder(Long memerId, String itemName, int itemPrice) {
       Member member = memberRepository.findById(memerId);
       int discountPrices = discountPolicy.disCount(member,itemPrice);

       return new Order(memerId, itemName, itemPrice, discountPrices);
    }
}
