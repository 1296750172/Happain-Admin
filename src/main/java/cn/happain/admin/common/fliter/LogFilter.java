package cn.happain.admin.common.fliter;

import cn.hutool.core.util.StrUtil;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


@WebFilter(filterName = "LogFilter",urlPatterns = "/*")
@Component
public class LogFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String method = httpServletRequest.getMethod();
        String contentType = httpServletRequest.getContentType();
        if (StrUtil.isNotEmpty(contentType)) {
            contentType = contentType.toLowerCase();
        }
        if (HttpMethod.POST.toString().equalsIgnoreCase(method) && StrUtil.isNotEmpty(contentType) && contentType.contains(MediaType.APPLICATION_JSON_VALUE)) {
            servletRequest = new RequestWrapper(httpServletRequest);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
