package de.secondparts.service.impl;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalTime;


@Configuration
public class CheckoutInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        var requestURI = request.getRequestURI();
       if (!request.equals("/api/shopping-card/checkout")){
           LocalTime now = LocalTime.now();
           System.out.println("CHECKOUT PREHANDLE INTERCEPTOR : You have a new Order to process " + now);
       }
        return true;
    }




}
