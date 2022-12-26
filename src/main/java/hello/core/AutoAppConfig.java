package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = "hello.core",
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class) //AppConfig 예제가 포함되지 않기 위해서 @Configuration 붙은 놈들은 스캔대상에서 제외
)
public class AutoAppConfig {

}
