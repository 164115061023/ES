package com.zl.builder.v2;

/**
 * @Description
 * @Author zl
 * @Date 2020/9/29 15:29
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args) {
        People people = new People.PeopleBuilder()
                .baseInfoBuilder("张三", 22, "男")
                .detailBuilder("13566668888", "3-7", "180cm", "60kg")
                //.otherBuilder("XXX", "XXX")
                .addressBuilder(new Address("湖南长沙", "某某区某某街"))
                .builder();

        System.out.println(people);
    }
}
