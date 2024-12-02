package hello.core;

import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {

    /*밖에서 생성 후 넣어주는 형식*/
    public MemberService memberService(){
        return new MemberServiceImpl(new MemoryMemberRepository());   /*new MemberRepository를 생성해서 넣어준다*/
        // -> 생성자를 통해서(new instance) 주입해준다라고 해서 생성자 주입이라고 표현함.
    }

    public OrderService orderService(){
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
        /*AppConfig를 통해서 orderService가 호출 될 때 OrderServiceImpl을 반환하는데 repository랑 plicy를 넘겨줌*/
    }
}
