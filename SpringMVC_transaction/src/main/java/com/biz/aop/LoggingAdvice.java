package com.biz.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut; 
import org.springframework.stereotype.Component;
 
@Aspect
@Component
public class LoggingAdvice {
	@Pointcut("execution(* com.biz.user.service.UsersServiceImpl.*(..))")
	public void logPointcut(){} 
	 
	@Around("logPointcut()")
	public Object log(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();   
        
        Object output = pjp.proceed(); 
        
        long elapsedTime = System.currentTimeMillis() - start;
        
        System.out.println("Method execution time: " + elapsedTime + " milliseconds.");
        return output;
	}

    @Around("execution(* com.biz.user.service.UsersServiceImpl.findUser(..))")
    public String around2(ProceedingJoinPoint pjp) throws Throwable {
        // 메소드 호출 전후에 Weaving하는 Advice
        System.out.println("***pre proceed");

        Signature sig = pjp.getSignature();
        System.out.println("Sig: " + sig.getName());
        String msg = (String) pjp.proceed();
        // msg = msg + "fuga";
        System.out.println("***post proceed");
        return msg;
    }
    

    @AfterThrowing(value = "execution(* com.biz.user.service.UsersServiceImpl.*(..))", throwing = "ex")
    public void afterThrowing(Throwable ex) {
        // 메소드 호출이 예외를 내보냈을 때 호출되는 Advice
        System.out.println("Hello Throwing! *** 예외가 생기면 나온다");
        System.out.println("exception value = " + ex.toString());
    }

}
