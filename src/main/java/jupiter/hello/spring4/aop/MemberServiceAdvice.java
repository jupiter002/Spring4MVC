package jupiter.hello.spring4.aop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

@Aspect
@Component
public class MemberServiceAdvice {
    private Logger logger = LogManager.getLogger(MemberServiceAdvice.class);

    @Around("execution(* jupiter.hello.spring4.controller.MemberController.myinfo(..))")
                                                    // myinfo(..)매개변수 상관없이 받는다
    public Object myinfoAOPProcess(ProceedingJoinPoint pjp)
            throws Throwable {
        logger.info("myinfoAOPProcess호출");
        HttpSession sess = null;

        //join point에서 넘겨준 매개변수에서 원하느 객체 추출
        for (Object o : pjp.getArgs()) {
            if (o instanceof HttpSession)
                sess = (HttpSession) o;
        }

        //포인트 컷 대상 메서드 실행
        if(sess.getAttribute("member")==null)
            return "redirect:/member/login";

        Object obj = pjp.proceed();
        return obj;
    }

}