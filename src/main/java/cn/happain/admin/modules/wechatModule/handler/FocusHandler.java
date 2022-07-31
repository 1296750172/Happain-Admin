package cn.happain.admin.modules.wechatModule.handler;

import cn.happain.admin.common.dto.Message;
import cn.happain.admin.modules.wechatModule.builder.ImageBuilder;
import cn.happain.admin.modules.wechatModule.builder.MsgCustomBuilder;
import cn.happain.admin.modules.wechatModule.builder.TextBuilder;
import cn.happain.admin.modules.wechatModule.config.WxMpProperties;
import cn.happain.admin.modules.wechatModule.exception.WeChatException;
import cn.happain.admin.modules.wechatModule.mapper.WxContentMapper;
import cn.happain.admin.modules.wechatModule.model.WxContent;
import cn.happain.admin.modules.wechatModule.service.EventService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpMessageHandler;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;


/*关注事件*/
@Component
@Slf4j
public class FocusHandler implements WxMpMessageHandler {


    @Autowired
    private EventService eventService;
    @Autowired
    private WxContentMapper wxContentMapper;
    @Autowired
    private WxMpProperties wxMpProperties;


    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage,
                                    Map<String, Object> context, WxMpService weixinService,
                                    WxSessionManager sessionManager) throws WxErrorException {
        log.info("新关注用户 OPENID: " + wxMessage.getFromUser());
        /*获取是哪个公众号*/
        String appId = weixinService.getWxMpConfigStorage().getAppId();
        /*码上帮你*/
        if(appId.equals(wxMpProperties.getConfigs().get(0).getAppId())) {
            // 获取微信用户基本信息
            try {
                WxMpUser userWxInfo = weixinService.getUserService()
                        .userInfo(wxMessage.getFromUser(), null);

                if (userWxInfo != null) {
                    log.info(eventService.subscribe(userWxInfo, appId).toString());
                }
            } catch (WxErrorException e) {
                if (e.getError().getErrorCode() == 48001) {
                    log.info("该公众号没有获取用户信息权限！");
                    throw new WeChatException("600","没有微信权限");

                }
            }

            /*处理关注后发送信息*/
            try {
                MsgCustomBuilder.textBuild(wxContentMapper.selectOne(new QueryWrapper<WxContent>().eq("type", "msb_focu")).getContent(),wxMessage,weixinService);
                return new ImageBuilder().build("uv2rQc-r4ru6XEYv837Astwxpva3cgLkKOvoxzgMyVPRdeqpMulbVZFU1HdX-iRu",wxMessage,weixinService);

            } catch (Exception e) {
                log.error(e.getMessage(), e);
            }
        }
        /*优优*/
        if(appId.equals(wxMpProperties.getConfigs().get(1).getAppId())){
            Message subscribe = eventService.youyou_subscribe(wxMessage.getFromUser(), appId);
            log.info(subscribe.toString());
            /*处理关注后发送信息*/
            try {
                return new TextBuilder().build(wxContentMapper.selectOne(new QueryWrapper<WxContent>().eq("type", "youyou_focu")).getContent(),wxMessage,weixinService);

            } catch (Exception e) {
                log.error(e.getMessage(), e);
            }

        }
        return null;
    }

    /**
     * 处理特殊请求，比如如果是扫码进来的，可以做相应处理
     */
    private WxMpXmlOutMessage handleSpecial(WxMpXmlMessage wxMessage) throws Exception {

        //TODO
        return null;
    }

}
