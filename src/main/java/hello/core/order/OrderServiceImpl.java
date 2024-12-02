package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);

        int discountPrice = discountPolicy.discount(member,itemPrice);  /*member 통으로 넘겨서 추후 확장성 체크*/
        /*설계가 매우 잘된 형태*/
        /*오더 서비스 입장에서는 할인 에 대한 것은 discountPolicy가 알아서 처리- 단일체계*/
        /*할인 문제는 할인쪽에서만 수정을 해서 유지보수 용이하게 수정을 하면 됨*/
        /*이게 구분이 안되어 있으면 오더서비스도 수정해야 됐을 것*/

        return new Order(memberId, itemName,itemPrice, discountPrice);

    }
}
