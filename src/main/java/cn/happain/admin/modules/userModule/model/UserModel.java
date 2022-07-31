package cn.happain.admin.modules.userModule.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author happain
 * @since 2022-07-31
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@TableName("admin_user")
public class UserModel implements Serializable {

    private static final long serialVersionUID = 1L;

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
    private String isVip;

    /**
     * vip等级
     */
    private String vipLevel;

    /**
     * 积分
     */
    private Double scope;

    /**
     * ip地址
     */
    private String ip;

    private LocalDateTime loginTime;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;


}
