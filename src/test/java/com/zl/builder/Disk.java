package com.zl.builder;

/**
 * @Description
 * @Author zl
 * @Date 2020/9/29 13:59
 * @Version 1.0
 */
public class Disk {
    private String manufacturers;//生产商
    private String specification;//型号
    private String readSpeed;//读取速度
    private String writeSpeed;//写入速度

    public Disk(String manufacturers, String specification, String readSpeed, String writeSpeed) {
        this.manufacturers = manufacturers;
        this.specification = specification;
        this.readSpeed = readSpeed;
        this.writeSpeed = writeSpeed;
    }

    @Override
    public String toString() {
        return "Disk{" +
                "manufacturers='" + manufacturers + '\'' +
                ", specification='" + specification + '\'' +
                ", readSpeed='" + readSpeed + '\'' +
                ", writeSpeed='" + writeSpeed + '\'' +
                '}';
    }
}
