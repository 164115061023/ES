package com.zl.factory;

public class SimpleCakeFactory {

    public FruitCake createFruitCake(){
        //before processing前置业务，如日志记录
        return new FruitCake();
    }

    public ChocolateCake createChocolateCake(){
        //before processing前置业务，如日志记录
        return new ChocolateCake();
    }

}
