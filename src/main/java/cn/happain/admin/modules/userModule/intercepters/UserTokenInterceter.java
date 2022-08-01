package cn.happain.admin.modules.userModule.intercepters;

import cn.happain.admin.common.consts.UserConst;
import cn.happain.admin.common.dto.Message;
import cn.happain.admin.common.services.RedisService;
import cn.happain.admin.common.utils.Utils;
import cn.hutool.core.util.StrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author happain
 * 检测未登陆的
 */
@Component
public class UserTokenInterceter implements HandlerInterceptor {

    @Autowired
    private RedisService redisService;



    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String au = request.getHeader("au");
        if(StrUtil.isNotEmpty(au)) {
            String key = "happain_token@" + au;
            /*存在这个token*/
            if(redisService.hasKey(key)){
                /*获取过期时间 如果只剩下24小时刷新token*/
                Long expire = redisService.getExpire(key);
                if(expire< UserConst.JWT_EXPIRE_REFURES) {
                    redisService.expire(key,UserConst.JWT_EXPIRE);
                }
                return true;
            }else {
                Utils.sendResponse(response,Message.failure401("认证过期"));
                return false;
            }
        }
        Utils.sendResponse(response, Message.failure404("auth fail"));
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
