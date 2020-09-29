package com.zl.builder.v2;

/**
 * @Description
 * @Author zl
 * @Date 2020/9/29 15:07
 * @Version 1.0
 */
public class People {
    String name;
    Integer age;
    String sex;

    String tel;
    String height;
    String weight;
    String birthday;

    Address address;

    String father;
    String mother;

    private People(){}

    public static class PeopleBuilder{
        People p = new People();

        public PeopleBuilder baseInfoBuilder(String name, Integer age, String sex){
            p.name = name;
            p.age = age;
            p.sex = sex;
            return this;
        }

        public PeopleBuilder detailBuilder(String tel, String birthday, String height, String weight){
            p.tel = tel;
            p.birthday = birthday;
            p.height = height;
            p.weight = weight;
            return this;
        }

        public PeopleBuilder addressBuilder(Address address){
            p.address = address;
            return this;
        }

        public PeopleBuilder otherBuilder(String father, String mother){
            p.father = father;
            p.mother = mother;
            return this;
        }

        public People builder(){
            return p;
        }
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", tel='" + tel + '\'' +
                ", height='" + height + '\'' +
                ", weight='" + weight + '\'' +
                ", birthday='" + birthday + '\'' + "\n" +
                ", address=" + address +
                ", father='" + father + '\'' +
                ", mother='" + mother + '\'' +
                '}';
    }
}
