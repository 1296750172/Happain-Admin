package cn.happain.admin.modules.wechatModule.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class WeChatException extends RuntimeException{

    /*错误消息*/
    private String message;

}
