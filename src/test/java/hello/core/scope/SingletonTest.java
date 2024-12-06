package hello.core.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import static org.assertj.core.api.Assertions.*;

public class SingletonTest {

    @Test
    void singleToneBeanFind(){

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SingletonBean.class);   /*클래스를 넣어주면 자동으로 컴포넌트 스캔을 이루어짐*/
        SingletonBean bean = ac.getBean(SingletonBean.class);
        SingletonBean bean2 = ac.getBean(SingletonBean.class);
        System.out.println("singletonBeanTest1 = " + bean);
        System.out.println("singletonBeanTest2 = " + bean2);
        assertThat(bean).isSameAs(bean2);

        ac.close();



    }

    @Scope("singleton")
    static class SingletonBean{

        @PostConstruct
        public void init(){
            System.out.println("SingletonBean.init");
        }

        @PreDestroy
        public void destroy(){
            System.out.println("SingletonBean.destroy");
        }
    }


}
