package com.zl.strategy;

public class Pig{

    Integer weight;
    Integer height;

    public Pig() {
    }

    public Pig(Integer weight, Integer height) {
        this.weight = weight;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Pig{" +
                "weight=" + weight +
                ", height=" + height +
                '}';
    }

}
