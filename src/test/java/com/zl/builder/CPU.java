package com.zl.builder;

/**
 * @Description
 * @Author zl
 * @Date 2020/9/29 13:58
 * @Version 1.0
 */
public class CPU {
    private String manufacturers;//生产商
    private String generation;//第几代
    private String frequency;//频率

    public CPU(String manufacturers, String generation, String frequency) {
        this.manufacturers = manufacturers;
        this.generation = generation;
        this.frequency = frequency;
    }

    @Override
    public String toString() {
        return "CPU{" +
                "manufacturers='" + manufacturers + '\'' +
                ", generation='" + generation + '\'' +
                ", frequency='" + frequency + '\'' +
                '}';
    }
}
