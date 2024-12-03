package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

//    private final MemberRepository memberRepository = new MemoryMemberRepository();
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    /*final 선언인 경우 기본으로 무조건  할당하든 아래처럼 생성자를 통해 할당하든 되어야함.*/
    /*인터페이스만 참조하고 있음. DIP 준수 중*/
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    /*AppConfig에서 받은것을 final 변수에 할당*/
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;

        /*FixDiscount인지, RateDiscount인지는 모름!!!*/
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);

        int discountPrice = discountPolicy.discount(member,itemPrice);
        return new Order(memberId, itemName,itemPrice, discountPrice);

    }

    /*싱글톤 테스트 용도*/
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
