package cn.happain.admin.modules.wechatModule.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WxUserCheck {


    /*验证码*/
    private String code;
    private String openId;
    private String nickname;
}
