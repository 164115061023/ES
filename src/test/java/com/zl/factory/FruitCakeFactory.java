package com.zl.factory;

public class FruitCakeFactory {

    public FruitCake create(){
        //before processing前置业务，如日志记录
        return new FruitCake();
    }

}
