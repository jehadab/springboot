package com.estate.AOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;


/**
 * Created by Jehad on 12/13/2021.
 */
@Aspect
@Configuration
public class EstateAspect  {

    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Before("@annotation(com.estate.AOP.AopLogger)")
        public void estateListener(JoinPoint joinPoint) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        logger.info("user : {} do {}", auth.getName() , joinPoint);

    }

}
