package com.chen.utils;


import com.chen.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.*;

import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public LoginInterceptor loginInterceptor() {
        return new LoginInterceptor();
    }


    @Override
    public void configurePathMatch(PathMatchConfigurer pathMatchConfigurer) {

    }

    /**配置内容裁决的一些选项**/
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer contentNegotiationConfigurer) {

    }

    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer asyncSupportConfigurer) {

    }

    /**默认静态资源处理器**/
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer defaultServletHandlerConfigurer) {

    }

    @Override
    public void addFormatters(FormatterRegistry formatterRegistry) {

    }

    /*新增登录拦截器*/
    @Override
    public void addInterceptors(InterceptorRegistry registry)
    {
        // 注册登录拦截器
        registry.addInterceptor( new LoginInterceptor())  //实现HandlerInterceptor接口的拦截器
                .addPathPatterns("/users/**") //对所有请求都拦截
                .excludePathPatterns("/users/login", "/users/register") //设置不需要拦截的过滤规则
                .excludePathPatterns("/users/id={id}",
                        "/users/all",
                        "/users/username={username}",
                        "/users/add/username={username}&password={password}&email={email}",
                        "/users/{username}&{password}");
    }

    /**静态资源处理**/
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry resourceHandlerRegistry) {

    }

    /**解决跨域问题**/
    @Override
    public void addCorsMappings(CorsRegistry corsRegistry) {

    }

    /**视图跳转控制器**/
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
    }


    /**配置视图解析器**/
    @Override
    public void configureViewResolvers(ViewResolverRegistry viewResolverRegistry) {

    }


    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> list) {

    }

    @Override
    public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> list) {

    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> list) {

    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> list) {

    }

    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> list) {

    }

    @Override
    public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> list) {

    }

    @Override
    public Validator getValidator() {
        return null;
    }

    @Override
    public MessageCodesResolver getMessageCodesResolver() {
        return null;
    }

}
