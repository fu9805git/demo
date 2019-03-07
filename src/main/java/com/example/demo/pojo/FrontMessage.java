package com.example.demo.pojo;

/**
 * 类说明: 返回给前台的消息
 *
 * @author 宋阳
 * @date 2019/3/5
 */
public class FrontMessage {
    private Boolean success;
    private String message;

    public FrontMessage() {
    }

    public FrontMessage(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "FrontMessage{" +
                "success=" + success +
                ", message='" + message + '\'' +
                '}';
    }
}
