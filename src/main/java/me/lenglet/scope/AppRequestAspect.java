package me.lenglet.scope;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@Aspect
public class AppRequestAspect {

    @Around("@annotation(AppRequest)")
    public Object createAppRequestContext(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            AppRequestContextHolder.initContext();
            return joinPoint.proceed();
        } finally {
            AppRequestContextHolder.resetContext();
        }
    }
}
