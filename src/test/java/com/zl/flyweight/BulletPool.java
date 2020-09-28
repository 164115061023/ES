package com.zl.flyweight;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author zl
 * @Date 2020/9/28 11:07
 * @Version 1.0
 */
public class BulletPool {
    List<Bullet> bulletPool = new ArrayList<>();
    {
        for (int i = 0; i < 5; i++) {
            bulletPool.add(new Bullet());
        }
    }

    public Bullet getBullet(){
        for (int i = 0; i < bulletPool.size(); i++) {
            if (!bulletPool.get(i).isLiving()){
                bulletPool.get(i).setLiving(true);
                return bulletPool.get(i);
            }
        }
        return new Bullet();
    }
}
