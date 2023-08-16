package cn.jdl.ecology.datahelper.exception;

import cn.jdl.ecology.datahelper.vo.Result;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolationException;

/**
 * @author chaoyang
 * @date 2022年09月15日 11:16
 */
@Aspect
@Component
public class ResultAspect {
    @Around("@annotation(cn.jdl.ecology.datahelper.exception.ResultHandler)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        Object proceed = null;
        try {
            proceed = joinPoint.proceed();
        } catch (ConstraintViolationException cve) {
            return Result.fail(cve.getMessage());
        } catch (Exception e) {
            return Result.fail(e.getMessage());
        }
        return proceed;
    }
}
