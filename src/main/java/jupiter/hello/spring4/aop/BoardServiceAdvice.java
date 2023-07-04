package jupiter.hello.spring4.aop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

@Aspect
@Component      //@Component: 스프링에 의해서 제어 받을 수 있게 하기 위해 사용
public class BoardServiceAdvice {
    private Logger logger = LogManager.getLogger(BoardServiceAdvice.class);
    @Pointcut("execution(* jupiter.hello.spring4.controller.BoardController.write(..))")
    public void writePoint(){}

    @Around("writePoint()")    // write()에 연결
    public Object writeAOPProcess(ProceedingJoinPoint pjp)
            throws Throwable {
        logger.info("writeAOPProcess호출");
        HttpSession sess = null;

        for (Object o : pjp.getArgs()) {
            if (o instanceof HttpSession)   // 조건식: o 가 HttpSession의 일부라면
                sess = (HttpSession) o;
        }

        if(sess.getAttribute("member")==null)
            return "redirect:/member/login";

        Object obj = pjp.proceed();
        return obj;
    }
}