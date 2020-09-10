package com.zl.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long id;
    private String username;
    private Integer age;
    private String password;

    public User(Long id,String name,Integer age){
        this.username = name;
        this.id=id;
        this.age=age;
    }


}
