package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;

public class OrderServiceImpl implements  OrderService{

    private final MemberRepository memberRepository ;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);//멤버찾기
        int discountPrice = discountPolicy.discount(member, itemPrice);
        //할인 정책을 고칠때 할인만 고치면 되고 주문쪽을 건들일 필요가 없다.

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
