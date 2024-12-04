package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.stereotype.Component;

@Component
/*새로운 할인 정책 추가를 위해 구현체 생성*/
public class RateDiscountPolicy implements DiscountPolicy {

    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){     /*enum은 ==로 구분*/
            return price * discountPercent / 100;
        }else{
            return 0;
        }


    }
}
