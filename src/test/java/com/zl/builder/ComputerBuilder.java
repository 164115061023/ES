package com.zl.builder;

/**
 * @Description
 * @Author zl
 * @Date 2020/9/29 14:10
 * @Version 1.0
 */
public interface ComputerBuilder {
    ComputerBuilder builderCPU(CPU cpu);
    ComputerBuilder builderDisk(Disk disk);
    ComputerBuilder builderMemory(Memory memory);
    Computer builderComputer();
}
