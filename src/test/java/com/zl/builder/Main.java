package com.zl.builder;

/**
 * @Description
 * @Author zl
 * @Date 2020/9/29 14:19
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args) {
        ComputerBuilder computerBuilder = new CommonComputerBuilder();
        Computer computer = computerBuilder.builderCPU(new CPU("intel", "10代酷睿", "4.0Ghz"))
                .builderDisk(new Disk("西部数据", "黑盘SN750", "3.4G/s", "1.7G/s"))
                .builderMemory(new Memory("海盗船", "16G", "3200Mhz"))
                .builderComputer();

        System.out.println(computer);
    }
}
