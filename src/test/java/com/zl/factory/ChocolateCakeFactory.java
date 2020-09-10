package com.zl.factory;

//巧克力口味蛋糕
public class ChocolateCakeFactory {

    public ChocolateCake create(){
        //before processing前置业务，如日志记录
        return new ChocolateCake();
    }
}
