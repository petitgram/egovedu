package sample.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import sample.di.business.domain.Product;

@Aspect
@Component
public class MyFirstAspect {

    @Before("execution(* getProduct(String))")
    public void before(JoinPoint jp) {
        // 메소드 시작 시에 Weaving하는 Advice
        System.out.println("Hello Before! *** 메소드가 호출되기 전에 나온다!");
        Signature sig = jp.getSignature();
        System.out.println("----->메소드 이름을 취득한다:" + sig.getName());
        Object[] o = jp.getArgs();
        System.out.println("-----> 가인수 값을 취득한다:" + o[0]);
    }

    @After("execution(* getProduct(String))")
    public void after() {
        // 메소드 종료 후에 Weaving하는 Advice
        System.out.println("Hello After! *** 메소드가 호출된 후에 나온다!");
    }

    @AfterReturning(value = "execution(* getProduct(String))", returning = "product")
    public void afterReturning(JoinPoint jp, Product product) {
        // 메소드 호출이 예외 송출 없이 종료했을 때 호출되는 Advice
        System.out.println("Hello AfterReturning! *** 메소드를 호출한 후에 나온다! ");
        // System.out.println("-----> return value = " + ret);
        Signature sig = jp.getSignature();
        System.out.println("-----> 메소드 이름을 취득한다:" + sig.getName());
        Object[] o = jp.getArgs();
        System.out.println("----->가인수 값을 취득한다:" + o[0]);
    }

    @Around("execution(* getProduct(String))")
    public Product around(ProceedingJoinPoint pjp) throws Throwable {
        // 메소드 호출 전후에 Weaving하는 Advice
        System.out.println("Hello Around! before *** 메소드를 호출하기 전에 나온다!");

        // Signature sig = pjp.getSignature();
        // System.out.println("-----> aop:around 메소드 이름을 취득한다:" + sig.getName());
        Product p = (Product) pjp.proceed();
        // msg = msg + ": 결과에 추가해본 메세지;
        System.out.println("Hello Around! after *** 메소드를 호출한 후에 나온다!");
        return p;
    }

    @Around("execution(* hoge())")
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

    @AfterThrowing(value = "execution(* getProduct(String))", throwing = "ex")
    public void afterThrowing(Throwable ex) {
        // 메소드 호출이 예외를 내보냈을 때 호출되는 Advice
        System.out.println("Hello Throwing! *** 예외가 생기면 나온다");
        System.out.println("exception value = " + ex.toString());
    }
}