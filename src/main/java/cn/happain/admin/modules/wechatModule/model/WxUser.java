package cn.happain.admin.modules.wechatModule.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

@TableName("wx_user")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class WxUser {

    @TableId
    private Long id;
    private String appId;
    private String openId;
    private Boolean subscribe;
    private String nickname;
    private Date subscribeTime;
    @TableField(fill= FieldFill.INSERT)
    private Date createTime;
    @TableField(fill= FieldFill.UPDATE)
    private Date updateTime;
}
