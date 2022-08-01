package cn.happain.admin.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class Message<T> {

    private long code;
    private String message;
    private T data;


    /**
     * 成功返回封装
     * */
    public static <T>Message<T> success(T data) {
        Message<T> tMessage = new Message<>();
        tMessage.setCode(200);
        tMessage.setData(data);
        tMessage.setMessage("success");
        return tMessage;
    }


    public static <T>Message<T> success() {
        Message<T> tMessage = new Message<>();
        tMessage.setCode(200);
        tMessage.setData(null);
        tMessage.setMessage("success");
        return tMessage;
    }

    /**
     * 失败返回封装 ，服务器的失败都是返回404
     * */
    public static Message failure404(String message) {
        Message tMessage = new Message<>();
        tMessage.setCode(404);
        tMessage.setData(null);
        tMessage.setMessage(message);
        return tMessage;
    }

    /**
     * 权限验证失败返回封装
     * */
    public static Message failure401(String message) {
        Message tMessage = new Message<>();
        tMessage.setCode(401);
        tMessage.setData(null);
        tMessage.setMessage(message);
        return tMessage;
    }

}
