package main;

import ch04.Calculator;
import config.JavaConfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainJavaAspect {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig.class);

        Calculator recCal = ctx.getBean("recCal", Calculator.class);
        long fiveFact = recCal.factorial(5);
        System.out.println("recCal.fac(5) = " + fiveFact);

//        Calculator impeCal = ctx.getBean("impeCal", Calculator.class);
//        long fiveFact2 = impeCal.factorial(5);
//        System.out.println("impeCal.fac(5) = " + fiveFact2);

    }
}
