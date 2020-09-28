package com.zl.flyweight;

/**
 * @Description
 * @Author zl
 * @Date 2020/9/28 11:07
 * @Version 1.0
 */
public class BulletTest {
    public static void main(String[] args) {
        BulletPool bp = new BulletPool();
        for (int i = 0; i < 10; i++) {
            Bullet bullet = bp.getBullet();
            System.out.println(bullet);
            //模拟子弹击中物体或碰到障碍物死亡
            if (i%2==0){
                bullet.setLiving(false);
            }
        }
    }
}
