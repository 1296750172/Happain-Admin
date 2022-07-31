package cn.happain.admin.modules.wechatModule.config;


import cn.happain.admin.modules.wechatModule.interceptor.WechatCheckInterceptor;
import me.chanjar.weixin.mp.api.WxMpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 拦截器配置
 * */
@Configuration
public class WxInterceptorConfig implements WebMvcConfigurer {

    @Autowired
    private WxMpService wxMpService;
    @Autowired
    private WxMpProperties wxMpProperties;



    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration registration = registry.addInterceptor(new WechatCheckInterceptor(wxMpService,wxMpProperties));
        registration.addPathPatterns("/wx/home/**");
        registration.excludePathPatterns();
    }
}
