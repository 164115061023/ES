package com.zl.strategy;

public class Dog{

    Integer age;

    public Dog(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "age=" + age +
                '}';
    }

}
