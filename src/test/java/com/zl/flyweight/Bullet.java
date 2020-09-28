package com.zl.flyweight;
import java.util.UUID;

/**
 * @Description
 * @Author zl
 * @Date 2020/9/28 11:01
 * @Version 1.0
 */
public class Bullet {
    public boolean living;
    public String id;

    public Bullet(){
        this.living = false;
        this.id = UUID.randomUUID().toString().replace("-", "");
    }

    public boolean isLiving() {
        return living;
    }

    public void setLiving(boolean living) {
        this.living = living;
    }

    @Override
    public String toString() {
        return "Bullet{" +
                "id='" + id + '\'' +
                '}';
    }
}
