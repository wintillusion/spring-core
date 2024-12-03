package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SingleTonTest {

    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer(){
        AppConfig appConfig = new AppConfig();
        /*조회 : 호출할 때마다 객체 생성하는지 확인*/
        MemberService memberService = appConfig.memberService();

        MemberService memberService2 = appConfig.memberService();

//        System.out.println("memberService" + memberService);
//        System.out.println("memberService2" + memberService2);

        /*서비스는 두개가 다르다는 것을 자동화 증명*/
        Assertions.assertThat(memberService).isNotSameAs(memberService2);
    }
}
