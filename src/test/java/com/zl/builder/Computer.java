package com.zl.builder;

/**
 * @Description
 * @Author zl
 * @Date 2020/9/29 13:58
 * @Version 1.0
 */
public class Computer {
    public CPU cpu;
    public Disk disk;
    public Memory memory;

    @Override
    public String toString() {
        return "Computer{" +
                "cpu=" + cpu + "\n" +
                ", disk=" + disk + "\n" +
                ", memory=" + memory +
                '}';
    }
}
