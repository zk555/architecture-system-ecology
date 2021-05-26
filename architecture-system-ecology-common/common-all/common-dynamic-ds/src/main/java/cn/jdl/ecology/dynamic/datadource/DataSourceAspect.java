package cn.jdl.ecology.dynamic.datadource;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

import javax.validation.constraints.NotNull;
/**
 * 在service层觉得数据源
 * <p>
 * 必须在事务AOP之前执行，所以实现Ordered,order的值越小，越先执行
 * 如果一旦开始切换到写库，则之后的读都会走写库
 */
@Slf4j
@Aspect
@Order(-1)
public class DataSourceAspect {

    private boolean isReadMethod(@NotNull String methodName) {
        // 方法名以query、find、get、select开头的方法名走从库
        return StringUtils.startsWithAny(methodName.toLowerCase(), new String[]{"query", "find", "get", "select"});
    }

    @Pointcut("execution(* cn.jdl.ecology..mapper..*(..)) ")
    public void aspect() { }

    /**
     * 之前的实现方式在Service调用其它service的方法时会再次触发切面，
     * 新service的数据源设置会覆盖旧的设置，造成写方法中调用读方法会出现问题
     * <p>
     * 改进后通不过判断
     *
     * @param joinPoint
     * @return
     */
    @Before("aspect()")
    public void setDataSourceType(JoinPoint joinPoint) {

        if (DynamicDataSourceHolder.get() == null) {
            final String methodName = joinPoint.getSignature().getName();
            if (isReadMethod(methodName)) {
                log.debug("动态切换数据库===切换到数据库==");
                DynamicDataSourceHolder.routeSlave();
            } else {
                log.debug("动态切换数据库===切换到写数据库==");
                DynamicDataSourceHolder.routeMaster();
            }
        }
    }


    @After("aspect()")
    public void after(JoinPoint point) {
        DynamicDataSourceHolder.clear();
    }
}
