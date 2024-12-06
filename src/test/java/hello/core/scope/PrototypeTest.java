package hello.core.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import static org.assertj.core.api.Assertions.assertThat;

public class PrototypeTest {

    @Test
    void prototypeBeanTest(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ProtoTypeBean.class);   /*클래스를 넣어주면 자동으로 컴포넌트 스캔을 이루어짐*/
        System.out.println("find prototypeBean1");
        ProtoTypeBean bean = ac.getBean(ProtoTypeBean.class);

        System.out.println("find prototypeBean2");
        ProtoTypeBean bean2 = ac.getBean(ProtoTypeBean.class);
        System.out.println("singletonBeanTest1 = " + bean);
        System.out.println("singletonBeanTest2 = " + bean2);
        assertThat(bean).isNotSameAs(bean2);


        bean.destroy(); /*직접 종료*/
        bean2.destroy();  /*직접 종료*/

        ac.close();

    }

    @Scope("prototype")
    static class ProtoTypeBean{

        @PostConstruct
        public void init(){
            System.out.println("ProtoTypeBean.init");
        }

        @PreDestroy
        public void destroy(){
            System.out.println("ProtoTypeBean.destroy");
        }
    }
}
