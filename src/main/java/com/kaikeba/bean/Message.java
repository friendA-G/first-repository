package com.kaikeba.bean;

import org.springframework.stereotype.Component;

/**
 * @Author: Gyx
 * @Date: 2021/2/23 17:01
 */
@Component("message")
public class Message {
    /**
     * 状态码 0成功 -1失败
     */
    private int status;
    /**
     * 消息结果
     */
    private String result;
    /**
     * 消息中的数据
     */
    private Object data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Message(String result) {
        this.result = result;
    }

    public Message(int status, String result) {
        this.status = status;
        this.result = result;
    }

    public Message(int status) {
        this.status = status;
    }

    public Message() {
    }

    public Message(int status, String result, Object data) {
        this.status = status;
        this.result = result;
        this.data = data;
    }
}
