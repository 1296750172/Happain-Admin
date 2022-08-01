package cn.happain.admin.exception;

import cn.happain.admin.common.dto.Message;
import cn.happain.admin.modules.wechatModule.exception.WeChatException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
@Slf4j
public class ExceptionController {


    /*微信公众号的自定义异常*/
    @ExceptionHandler(WeChatException.class)
    public Message weChatExceptionHandler(HttpServletRequest req, WeChatException e) {
        log.error(e.getMessage());
        return Message.failure404(e.getMessage());
    }

    /*捕获全局异常*/
    @ExceptionHandler(Exception.class)
    public Message globalExceptionHandler(HttpServletRequest req, Exception e) {
        log.error(e.getMessage());
        return Message.failure404(e.getMessage());

    }
}
