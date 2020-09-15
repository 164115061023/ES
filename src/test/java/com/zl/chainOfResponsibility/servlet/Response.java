package com.zl.chainOfResponsibility.servlet;

/**
 * @Description
 * @Author zl
 * @Date 2020/9/15 14:06
 * @Version 1.0
 */
public class Response {
    String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Response{" +
                "msg='" + msg + '\'' +
                '}';
    }
}
