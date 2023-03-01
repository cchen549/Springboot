package com.chen.interceptor;

import com.chen.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginInterceptor implements HandlerInterceptor {
    private static int preFlag = 0, postFlag = 0, afterFlag = 0;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url = request.getRequestURI();
        //当前请求地址是否为login
        System.out.println("拦截器拦截到了请求，请求的URI为：" + url);
        System.out.println("拦截次数=" + (++preFlag));
        if (url.endsWith("login") || url.endsWith("toLogin")) {
            //登录请求，不拦截
            return true;
        }
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user != null) {
            // 用户已经登录，允许访问请求
            System.out.println("登录的用户为 " + user.getName());
            return true;
        } else {
            // 用户未登录，将请求重定向到登录页面
            response.sendRedirect(request.getContextPath() + "/users/toLogin");
            return false;
        }
    }

    //在Controller处理完请求要进行视图的跳转的时候进行调用此方法
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("拦截器开始解析请求" + modelAndView.getViewName());
        System.out.println("解析请求次数=" + (++postFlag));
    }

    // 在视图跳转完成后调用此方法
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("请求完成");
        System.out.println("渲染次数=" + (++afterFlag));
    }
}
