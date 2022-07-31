package cn.happain.admin.modules.wechatModule.service;

import cn.happain.admin.modules.wechatModule.config.WxMpProperties;
import me.chanjar.weixin.mp.api.WxMpMessageRouter;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WechatService {
    @Autowired
    public WxMpService wxMpService;
    @Autowired
    private WxMpProperties wxMpProperties;
    @Autowired
    private WxMpMessageRouter wxMpMessageRouter;
    /*处理消息*/
    public String dealMessage(int index,WxMpXmlMessage message) {
        WxMpXmlOutMessage r = wxMpMessageRouter.route(wxMpProperties.getConfigs().get(index).getAppId(),message);
        return r.toXml();
    }


}
