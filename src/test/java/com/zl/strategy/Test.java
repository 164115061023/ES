package com.zl.strategy;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {


        /**
         * 在排序中，我们只需要调用Sorter中sort方法传入对象数组和想要的比较器实现类即可。
         * 实际开发中会比排序复杂，这样优势更加明显，更改策略只需更换相应的策略实现类即可，扩展性强
         */

        //Dog[] dogs = {new Dog(3),new Dog(5), new Dog(1), new Dog(2)};
        Pig[] pigs = {new Pig(3,3), new Pig(5,5), new Pig(1,1),new Pig(4,4)};

        Sorter<Pig> sorter = new Sorter<>();
        sorter.sort(pigs,new PigWeightComparator());//根据Pig类对象数组weight属性排序
        System.out.println(Arrays.toString(pigs));

    }

}
