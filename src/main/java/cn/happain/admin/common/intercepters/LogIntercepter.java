package cn.happain.admin.common.intercepters;

import cn.happain.admin.common.fliter.RequestWrapper;
import cn.happain.admin.common.utils.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 日志记录
 * */
@Component
@Slf4j
public class LogIntercepter implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        RequestWrapper requestWrapper = new RequestWrapper(request);
        log.warn("===============");
        log.warn("请求地址是: "+request.getRequestURL().toString());
        log.warn("请求方法是: "+request.getMethod());
        log.warn("请求ip是: "+ Utils.getIpAddr(request));
        log.warn("请求内容是: "+ requestWrapper.getBody());
        log.warn("===============");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println(response);
    }
}
