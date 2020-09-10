package com.zl.strategy;

public class DogComparator implements Comparator<Dog> {
    @Override
    public int compareTo(Dog o1, Dog o2) {
        if(o1.age>o2.age)return 1;
        else if(o1.age<o2.age)return -1;
        else return 0;
    }
}
