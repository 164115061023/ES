package com.zl.pojo;

import lombok.Data;

import java.util.List;

/**
 * @Description
 * @Author zl
 * @Date 2020/9/10 17:41
 * @Version 1.0
 */
@Data
public class Student {
    private int id;
    private String name;
    private int age;
    private List<Teacher> teacherList;
}
