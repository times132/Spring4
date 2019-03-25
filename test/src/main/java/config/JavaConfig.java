package config;

import aspect.ExeTimeAspect2;
import ch04.Calculator;
import ch04.RecCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class JavaConfig {
    @Bean
    public ExeTimeAspect2 exeTimeAspect(){
        return new ExeTimeAspect2();
    }

    @Bean
    public Calculator recCal(){
        return new RecCalculator();
    }

//    @Bean
//    public Calculator impeCal(){
//        return new ImpeCalculator();
//    }
}
