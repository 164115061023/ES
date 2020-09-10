package com.zl.abstractFactory;

public class Test {
    public static void main(String[] args) {

        /*FruitCake cake = new FruitCake();
        cake.eat();
        RedCandle candle = new RedCandle();
        candle.see();
        SimpleStyle style = new SimpleStyle();
        style.style();*/

        AbstractFactory factory = new FirstProductCake();

        Cake cake = factory.createCake();
        cake.eat();
        Candle candle = factory.createCandle();
        candle.see();
        Style style = factory.createStyle();
        style.style();


    }
}
