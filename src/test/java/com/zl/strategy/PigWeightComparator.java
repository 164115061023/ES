package com.zl.strategy;

public class PigWeightComparator implements Comparator<Pig> {

    @Override
    public int compareTo(Pig o1, Pig o2) {
        if(o1.weight>o2.weight)return 1;
        else if(o1.weight<o2.weight)return -1;
        else return 0;
    }
}
