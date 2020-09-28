package com.zl.flyweight;

/**
 * @Description
 * @Author zl
 * @Date 2020/9/28 10:10
 * @Version 1.0
 */
public class StringTest {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "abc";
        String s3 = new String("abc");
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s1 == s3.intern());
        System.out.println(s3.intern());
        System.out.println(s1 == s3);
    }
}
