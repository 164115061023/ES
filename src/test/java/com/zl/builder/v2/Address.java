package com.zl.builder.v2;

/**
 * @Description
 * @Author zl
 * @Date 2020/9/29 15:07
 * @Version 1.0
 */
public class Address {
    String Province;
    String detail;

    public Address(String province, String detail) {
        Province = province;
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "Address{" +
                "Province='" + Province + '\'' +
                ", detail='" + detail + '\'' +
                '}';
    }
}
