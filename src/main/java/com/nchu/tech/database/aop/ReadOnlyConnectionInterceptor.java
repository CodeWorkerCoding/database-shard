package com.nchu.tech.database.aop;

import com.nchu.tech.database.annotation.ReadOnlyConnection;
import com.nchu.tech.database.config.DataSourceContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * 只读拦截器 AOP
 * Created by fujianjian on 2017/7/12.
 */
@Aspect
@Component
@Slf4j
public class ReadOnlyConnectionInterceptor implements Ordered {

    @Around(value = "@annotation(readOnlyConnection)")
    public Object processd(ProceedingJoinPoint proceedingJoinPoint, ReadOnlyConnection readOnlyConnection)
            throws Throwable {
        try {
            log.info("set data source connect to read only");
            DataSourceContextHolder.setDataSourceType(DataSourceContextHolder.DataSourceType.SLAVE);
            Object result = proceedingJoinPoint.proceed();
            return result;
        } finally {
            DataSourceContextHolder.clearDataSourceType();
            log.info("restore data source connection");
        }
    }

    //@Around(value = "execution(com.nchu.tech.database*.(..))")
    //@Around(value = "execution(public * find*(..))")
    public Object processd(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        try {
            log.info("set data source connect to read only");
            DataSourceContextHolder.setDataSourceType(DataSourceContextHolder.DataSourceType.SLAVE);
            Object result = proceedingJoinPoint.proceed();
            return result;
        } finally {
            DataSourceContextHolder.clearDataSourceType();
            log.info("restore data source connection");
        }
    }


    @Override
    public int getOrder() {
        return 0;
    }
}
