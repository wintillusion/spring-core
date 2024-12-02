package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.order.Order;
import hello.core.order.OrderService;

public class OrderApp {

    public static void main(String[] args) {
//        MemberService memberService = new MemberServiceImpl();
//        OrderService orderService = new OrderServiceImpl();

        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        /*orderService를 impl을 반환하는데 생성자로 memoryMemberRepository와 fixDiscountPolicy를 넘겨줌.*/
        /*orderServiceImpl이 생성된 두 객체를 참조하도록 세팅*/
        /*그렇게 해서 완성된 OrderServiceImpl 객체를 돌려주고 있는 것*/

        Long memberId = 1L;
        Member member = new Member(memberId, "MemberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "OrderA", 10000);
        System.out.println("order = "+ order);
        System.out.println("order.calculatePrice = "+ order.calculatePrice());
    }
}
