package com.zl.strategy;

public class PigHeightComparator implements Comparator<Pig> {

    @Override
    public int compareTo(Pig o1, Pig o2) {
        if(o1.height>o2.height)return 1;
        else if(o1.height<o2.height)return -1;
        else return 0;
    }
}
