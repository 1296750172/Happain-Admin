package cn.happain.admin.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class InterceptorConfig implements WebMvcConfigurer {


    /**
     * 添加拦截器
     * 顺序和拦截器添加顺序有关系
     * */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

    }

    /**
     * 配置统一的前缀
     * */
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {

    }

    /**
     * 配置资源路径
     * */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

    }
}
