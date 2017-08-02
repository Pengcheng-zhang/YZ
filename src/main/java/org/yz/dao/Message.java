package org.yz.dao;

/**
 * Created by 张鹏程 on 2017/6/19.
 */
public class Message {
    private String code;
    private String message;
    private String result;

    public Message(String code, String message, String result) {
        this.code = code;
        this.message = message;
        this.result = result;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
