package com.zl.builder;

/**
 * @Description
 * @Author zl
 * @Date 2020/9/29 14:17
 * @Version 1.0
 */
public class CommonComputerBuilder implements ComputerBuilder{
    Computer computer = new Computer();
    @Override
    public ComputerBuilder builderCPU(CPU cpu) {
        computer.cpu = cpu;
        return this;
    }

    @Override
    public ComputerBuilder builderDisk(Disk disk) {
        computer.disk = disk;
        return this;
    }

    @Override
    public ComputerBuilder builderMemory(Memory memory) {
        computer.memory = memory;
        return this;
    }

    @Override
    public Computer builderComputer() {
        return computer;
    }
}
