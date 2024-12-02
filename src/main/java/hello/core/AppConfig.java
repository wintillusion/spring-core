package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {

    /*밖에서 생성 후 넣어주는 형식*/
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());   /*new MemberRepository를 생성해서 넣어준다*/
        // -> 생성자를 통해서(new instance) 주입해준다라고 해서 생성자 주입이라고 표현함.
    }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
        /*AppConfig를 통해서 orderService가 호출 될 때 OrderServiceImpl을 반환하는데 repository랑 plicy를 넘겨줌*/
    }

//    public DiscountPolicy discountPolicy(){
//        return new FixDiscountPolicy();
//    }
    public DiscountPolicy discountPolicy(){
    return new RateDiscountPolicy();
}
    /*service들 외 repository도 명시를 해주므로서 가독성 향상, 설계에 대한 그림이 구성정보를 정확히 작성을 해주는게 좋다.*/
    /*MemoryRepository 중복삭제 및 하나만 관리를 해주면 됨.*/
    /*메소드를 보면 역할과 구현 클래스가 보이면서 전체 구성 확인 가능*/


}
