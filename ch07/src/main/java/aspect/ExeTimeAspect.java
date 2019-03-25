package aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;

import java.util.Arrays;

public class ExeTimeAspect {
    public Object measure(ProceedingJoinPoint joinPoint) throws Throwable{ //ProceedingJoinPoint 타입 파라메터로 대상 객체의 메소드 호출가능
        long start = System.nanoTime();
        try {
            Object result = joinPoint.proceed(); //대상객체의 메소드를 호출하는 방법
            return result;
        }finally {
            long finish = System.nanoTime();
            Signature sig = joinPoint.getSignature(); //호출되는 메서드에 대한 정보
            System.out.printf("%s.%s(%s) 실행시간 : %d ns\n", joinPoint.getTarget().getClass().getSimpleName(),
                    sig.getName(), Arrays.toString(joinPoint.getArgs()),
                    (finish - start));
        }
    }
}
