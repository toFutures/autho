package com.lsdd.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.ObjectError;

import java.lang.reflect.Method;

@Component
@Aspect
public class LogAspect {

    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Pointcut("execution(* com.lsdd.controller.*.*(..))")
    public void controllerAspect(){

    }

    @Pointcut("execution(* com.lsdd.service.impl.*.*(..))")
    public void serviceAspect(){

    }

    @Before("controllerAspect()")
    public void doBefore(JoinPoint joinPoint){
        getLog(joinPoint,null);
    }

    private void getLog(JoinPoint joinPoint,Throwable e){
        String className = joinPoint.getTarget().getClass().getName();
        String methodName=joinPoint.getSignature().getName();

        String str=className+"--------------------------------"+methodName;
        Object[] params=joinPoint.getArgs();
        for(Object param:params){
            logger.info("@Before:params:" + param);
        }
        MethodSignature methodSignature=(MethodSignature)joinPoint.getSignature();
        // getMethod
        Method method = methodSignature.getMethod();
        // get note
        ILog logAnno = method.getAnnotation(ILog.class);
        // params
        String operateType = logAnno.operationType();
        String operateName = logAnno.operationName();
        logger.info(str);
        logger.info("type：" + operateType + "##" + "action："+ operateName);

    }
    /**
     * after inform
     *
     * @author Stephen
     * @Time 2019年9月25日 14:48:49
     */
    @After("serviceAspect()")
    public void after(JoinPoint joinPoint) {
        logger.info("Service&Success================================");
    }

    @Before("controllerAspect()")
    public void doBeforeController(JoinPoint joinPoint)
    {
        getLog(joinPoint, null);
    }
    /**
     * after inform
     *
     * @author Stephen
     * @Time 2019年9月25日 14:48:49
     */
    @After("controllerAspect()")
    public void afterController(JoinPoint joinPoint) {
        logger.info("Controller&Success================================");
    }


}
