package com.zl.chainOfResponsibility;

/**
 * @Description
 * @Author zl
 * @Date 2020/9/14 17:36
 * @Version 1.0
 */
public class CharFilter implements Filter{
    @Override
    public void doFilter(Msg msg) {
        String s =msg.getMsg();
        s = s.replace("<","[");
        s = s.replace(">","]");
        msg.setMsg(s);
    }
}
