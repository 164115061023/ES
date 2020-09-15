package com.zl.chainOfResponsibility.servlet;

/**
 * @Description
 * @Author zl
 * @Date 2020/9/14 17:34
 * @Version 1.0
 */
public class Request {
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Msg{" +
                "msg='" + msg + '\'' +
                '}';
    }
}
