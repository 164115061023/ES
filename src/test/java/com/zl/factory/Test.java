package com.zl.factory;

public class Test {
    public static void main(String[] args) {

        /*//定制水果味蛋糕
        Cake cake = new FruitCake();
        cake.eat();*/

        /*//生产水果蛋糕
        FruitCake fruitCake = new SimpleCakeFactory().createFruitCake();
        fruitCake.eat();

        //生产巧克力蛋糕
        ChocolateCake chocolateCake = new SimpleCakeFactory().createChocolateCake();
        chocolateCake.eat();*/

        FruitCake fruitCake = new FruitCakeFactory().create();
        fruitCake.eat();

        ChocolateCake chocolateCake = new ChocolateCakeFactory().create();
        chocolateCake.eat();


    }
}
