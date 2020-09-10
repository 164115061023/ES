package com.zl.strategy;

public class Sorter<T> {

    public void sort(T[] ts, Comparator<T> comparator){
        for(int i=0; i<ts.length; i++){
            for(int j=0; j<ts.length-1-i; j++){
                if(comparator.compareTo(ts[j],ts[j + 1]) > 0){
                    swap(ts,j,j+1);
                }
            }
        }
    }
    public void swap(T[] a, int i, int j){
        T t=a[i];
        a[i]=a[j];
        a[j]=t;
    }

}
