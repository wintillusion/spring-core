package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
//        MemberService memberService = new MemberServiceImpl();    /*appConfig를 사용해서 리팩토링*/

        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();    /*여기 안에는 impl을 만들고, 이 impl은 memoryMemberRepository를 사용한다고 명시되어있음(param)*/
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("member : " + member.getName());
        System.out.println("find Member : " + findMember.getName());

        /*순수한 자마 코드에 메서드 실행 및 테스트*/
    }
}
