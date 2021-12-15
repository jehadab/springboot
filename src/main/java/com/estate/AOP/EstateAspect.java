package com.estate.AOP;

import com.estate.assets.models.EstateModel;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
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
//    @Before("execution(com.estate.components.EstateService.updateEstate() " +
//            "and args(id , name , price))")
//        public void estateListener(JoinPoint joinPoint , Long id , String name , Long price) {
//
//        logger.info("user : {} do update " +
//                        "a update action on state with id {} : \n" +
//                        " estate Name : {} " +
//                "estate value : {} \n", auth.getName() , id , name, price);
//
//
//    }
    @AfterReturning(pointcut = "execution(* com.estate.components.estateAPIs.EstateService.updateState(..))" , returning = "estate")
    public void updateEstateAop(JoinPoint joinPoint , Object estate){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        logger.info("\nuser : {}" +
                "a update action on state with id {} : \n" +
                " estate Name : {} " +
                "estate value : {} \n", auth.getName() , ((EstateModel) estate).getId()
                , ((EstateModel)estate).getName() , ((EstateModel)estate).getPrice());

    }
    @AfterReturning(pointcut = "execution(* com.estate.components.estateAPIs.EstateService.addEstate(..))" , returning = "estate")
    public void addEstateAop(JoinPoint joinPoint , Object estate){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        logger.info("\nuser : {}" +
                "a update action on state with id {} : \n" +
                " estate Name : {} " +
                "estate value : {} \n", auth.getName() , ((EstateModel) estate).getId() ,
                ((EstateModel)estate).getName(),((EstateModel)estate).getPrice());

    }
    @AfterReturning(pointcut = "execution(* com.estate.components.estateAPIs.EstateService.deleteEstate(..))" , returning = "id")
    public void deleteEstateAOP(JoinPoint joinPoint , String id){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        logger.info("\nuser : {}" +
                "a delete to {} \n", auth.getName() , id);

    }
    @AfterReturning(pointcut = "execution(* com.estate.components.estateAPIs.EstateService.sellState(..))" , returning = "estate")
    public void sellEstateAop(JoinPoint joinPoint , Object estate){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        logger.info("\nuser : {}" +
                "a update action on state with id {} : \n" +
                " estate Name : {} " +
                "estate Price : {} \n", auth.getName() , ((EstateModel) estate).getId()
                , ((EstateModel)estate).getName() , ((EstateModel)estate).getPrice() );

    }
//    @AfterReturning(pointcut = "@annotation(AopLogger)" , returning = "estate")
//    public void estatelog(JoinPoint joinPoint , Object estate){
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//
//        logger.info("\nuser : {}" +
//                "a update action on state with id {} : \n" +
//                " estate Name : {} " +
//                "estate value : {} \n", auth.getName() , ((EstateModel) estate).getId() , ((EstateModel)estate).getName());
//    }





}
