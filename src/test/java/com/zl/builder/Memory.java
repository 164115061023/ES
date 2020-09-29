package com.zl.builder;

/**
 * @Description
 * @Author zl
 * @Date 2020/9/29 13:59
 * @Version 1.0
 */
public class Memory {
    private String manufacturers;//生产商
    private String capacity;//容量
    private String frequency;//内存频率

    public Memory(String manufacturers, String capacity, String frequency) {
        this.manufacturers = manufacturers;
        this.capacity = capacity;
        this.frequency = frequency;
    }

    @Override
    public String toString() {
        return "Memory{" +
                "manufacturers='" + manufacturers + '\'' +
                ", capacity='" + capacity + '\'' +
                ", frequency='" + frequency + '\'' +
                '}';
    }
}
