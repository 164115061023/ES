package com.zl.chainOfResponsibility;

/**
 * @Description
 * @Author zl
 * @Date 2020/9/14 17:37
 * @Version 1.0
 */
public class SensitiveWordFilter implements Filter{
    @Override
    public void doFilter(Msg msg) {
        String s = msg.getMsg();
        s = s.replaceAll("007", "996");
        msg.setMsg(s);
    }
}
