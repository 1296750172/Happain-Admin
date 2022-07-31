package cn.happain.admin.modules.wechatModule.model.vo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * @author happain
 * @since 2022-04-24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@TableName("youyou_user")
public class YouyouUser {
        @TableId(value = "id", type = IdType.AUTO)
        private Integer id;

        /**
         * 用户名跟微信id一样 初始化的时候
         */
        private String username;

        /**
         * 初始化为空
         */
        private String password;

        /**
         * 微信id
         */
        private String wxId;

        /**
         * 是否vip
         */
        private Boolean isVip;

        /**
         * vip等级
         */
        private String vipLevel;

        /**
         * 积分
         */
        private Integer scope;

        /**
         * ip地址
         */
        private String ip;

        /**
         * 最后登陆时间
         * */
        private LocalDateTime loginTime;


        @TableField(fill = FieldFill.INSERT)
        private LocalDateTime createTime;

        @TableField(fill = FieldFill.INSERT_UPDATE)
        private LocalDateTime updateTime;



}
