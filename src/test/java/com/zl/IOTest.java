package com.zl;

import org.assertj.core.util.Strings;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.concurrent.atomic.LongAdder;


public class IOTest {
    int a=0,b=1;

    @Test
    public void inputOutputAndResult() throws IOException {

        /*FileInputStream fileInputStream1 = new FileInputStream(new File("E:\\111.txt"));
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream1);*/
        StringBuilder stringBuilder = new StringBuilder();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("E:\\111.txt")));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("E:/222.txt")));
        int len=-1;
        char[] buff = new char[1024];
        while((len = bufferedReader.read(buff))!=-1){
            //System.out.println('A'+fileInputStream1.read()-'A');
            String s = String.valueOf(buff,0,len);
            System.out.println(len);
            System.out.println(s);
            stringBuilder.append(s);
        }


        bufferedWriter.write(stringBuilder.toString());
        bufferedWriter.flush();


        System.out.println(stringBuilder.toString());
        //FileInputStream fileInputStream2 = new FileInputStream(new File(""));



    }

    @Test


    public void test(){
        Object object = new Object();

    }


}
