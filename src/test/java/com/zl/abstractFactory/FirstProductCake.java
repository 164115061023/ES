package com.zl.abstractFactory;

public class FirstProductCake extends  AbstractFactory{
    @Override
    Cake createCake() {
        return new FruitCake();
    }

    @Override
    Candle createCandle() {
        return new RedCandle();
    }

    @Override
    Style createStyle() {
        return new SimpleStyle();
    }
}
