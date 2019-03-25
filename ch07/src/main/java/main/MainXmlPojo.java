package main;

import ch07.Calculator;
import ch07.ImpeCalculator;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainXmlPojo {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:aopPojo.xml");

        Calculator impeCal = ctx.getBean("impeCal", Calculator.class); //인터페이스를 이용해 프록시 생성
        long fiveFact1 = impeCal.factorial(5);
        System.out.println("impeCal.fac(5) = " + fiveFact1);

        ImpeCalculator impeCal2 = ctx.getBean("impeCal", ImpeCalculator.class); //클래스를 이용해 프록시 생성
        long number = impeCal2.test(5);


        Calculator recCal = ctx.getBean("recCal", Calculator.class);
        long fiveFact2 = recCal.factorial(5);
        System.out.println("recCal.fac(5) = " + fiveFact2);
    }
}
