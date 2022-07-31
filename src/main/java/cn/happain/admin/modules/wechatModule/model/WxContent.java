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

@TableName("wx_content")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class WxContent {

    @TableId
    private Long id;
    private String content;
    private String type;

    @TableField(fill= FieldFill.INSERT)
    private Date createTime;
}
