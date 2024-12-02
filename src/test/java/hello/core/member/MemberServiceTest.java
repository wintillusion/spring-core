package hello.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl();


    @Test
    void join(){
        //given
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);
//        Member findMember = memberService.findMember(2L);

        //then
        Assertions.assertThat(member).isEqualTo(findMember);
    }
    /*요즘에는 테스트 개발을 필수라고 보면 된다.*/

}