package cn.happain.admin.modules.wechatModule.handler;


import cn.happain.admin.modules.wechatModule.builder.ImageBuilder;
import cn.happain.admin.modules.wechatModule.builder.MsgCustomBuilder;
import cn.happain.admin.modules.wechatModule.builder.TextBuilder;
import cn.happain.admin.modules.wechatModule.config.WxMpProperties;
import cn.happain.admin.modules.wechatModule.mapper.WxContentMapper;
import cn.happain.admin.modules.wechatModule.model.WxContent;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpMessageHandler;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author Binary Wang(https://github.com/binarywang)
 */
@Component
public class MenuHandler implements WxMpMessageHandler {


    @Autowired
    private WxContentMapper wxContentMapper;
    @Autowired
    private WxMpProperties wxMpProperties;


    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage,
                                    Map<String, Object> context, WxMpService weixinService,
                                    WxSessionManager sessionManager) throws WxErrorException {


        /*appid 哪个公众号*/
        String appId = weixinService.getWxMpConfigStorage().getAppId();
        /*码上帮你*/
        if(appId.equals(wxMpProperties.getConfigs().get(0).getAppId())) {
            /*点击购买*/
            if (WxConsts.EventType.CLICK.equals(wxMessage.getEvent()) && wxMessage.getEventKey().equals("BUY")){

            }
            /*关于我们*/
            if(WxConsts.EventType.CLICK.equals(wxMessage.getEvent()) && wxMessage.getEventKey().equals("ABOUT")) {
                //那天微信开发文档推送给关注者
                MsgCustomBuilder.textBuild( wxContentMapper.selectOne(new QueryWrapper<WxContent>().eq("type", "msb_about")).getContent(), wxMessage,weixinService);
                return new ImageBuilder().build("uv2rQc-r4ru6XEYv837Astwxpva3cgLkKOvoxzgMyVPRdeqpMulbVZFU1HdX-iRu",wxMessage,weixinService);

            }
        }
        /*优优*/
        if(appId.equals(wxMpProperties.getConfigs().get(1).getAppId())) {
            if(WxConsts.EventType.CLICK.equals(wxMessage.getEvent()) && wxMessage.getEventKey().equals("WORK")) {

                return new TextBuilder().build(wxContentMapper.selectOne(new QueryWrapper<WxContent>().eq("type", "youyou_about")).getContent(),wxMessage,weixinService);

            }
        }




        return WxMpXmlOutMessage.TEXT().content("未识别操作")
                .fromUser(wxMessage.getToUser())
                .toUser(wxMessage.getFromUser())
                .build();
    }

}
