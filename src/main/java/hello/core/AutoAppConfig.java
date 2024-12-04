package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration  /*이 애노테이션 안에도 Component가 있음*/
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(type= FilterType.ANNOTATION, classes = Configuration.class)
        /*필터를 통해 Configuration 애노테이션이 붙은걸 뺀다(AutoAppConfig과 AppConfig 충돌 방지)*/
)  /*@Compoent 클래스를 찾아서 자동으로 spring bean으로 등록하는 애노테이션*/
public class AutoAppConfig {

}

