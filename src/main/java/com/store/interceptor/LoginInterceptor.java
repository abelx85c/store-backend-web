package com.store.interceptor;


import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("===========================");
        System.out.println("LoginInterceptor preHandle");
        Object obj = request.getSession().getAttribute("uid");
        System.out.println("request getSession getAttribute uid: " + obj);
        if( obj == null ){
            System.out.println("request getSession getAttribute uid == null");
            //response.sendRedirect("/web/login.html");
            //return false;
        }


        return true;
    }
}
