package com.space.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @describe:
 * @author: 彭爽pross
 * @date: 2019/02/16
 */
@Component
public class AccessInterceptor  implements HandlerInterceptor {

    @Override
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {
    }

    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
            throws Exception {

    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
        System.out.println("getContextPath:" + request.getContextPath());
        System.out.println("getServletPath:" + request.getServletPath());
        System.out.println("getRequestURI:" + request.getRequestURI());
        System.out.println("getRequestURL:" + request.getRequestURL());
        System.out.println("getRealPath:" + request.getSession().getServletContext().getRealPath("image"));
        return true;
    }

}
