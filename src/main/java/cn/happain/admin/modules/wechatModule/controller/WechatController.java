package cn.happain.admin.modules.wechatModule.controller;

import cn.happain.admin.modules.wechatModule.config.WxMpProperties;
import cn.happain.admin.modules.wechatModule.service.WechatService;
import cn.hutool.http.server.HttpServerResponse;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
@RequestMapping("/wx/home")
public class WechatController {

    @Autowired
    private WxMpService wxService;
    @Autowired
    private WxMpProperties wxMpProperties;
    @Autowired
    private WechatService wechatService;
    /*验证消息有效性*/
    @GetMapping("/{index}")
    public String wxcheck(@PathVariable String index,HttpServletRequest httpServletRequest) {

        String echostr = httpServletRequest.getAttribute("echostr").toString();
        return echostr;
    }

    /*获取用户发送的消息*/
    @PostMapping("/{index}")
    public String getmessage(@PathVariable String index,HttpServletRequest httpServletRequest, HttpServerResponse httpServerResponse) throws IOException {
        httpServletRequest.setCharacterEncoding("UTF-8");
        WxMpXmlMessage message= WxMpXmlMessage.fromXml(httpServletRequest.getInputStream());
        return wechatService.dealMessage(Integer.parseInt(index),message);
    }






}
