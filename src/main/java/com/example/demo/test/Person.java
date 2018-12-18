package com.example.demo.test;

import lombok.Data;

/** 
* @author LvZheng  
* 创建时间：2018年1月19日 下午3:32:06  
* 项目名称：demo-1   
* @version 1.0   
* @since JDK 1.8  
* 文件名称：cccc.java    
*/
@Data
public class Person {
    private Long id;

    private String name;

    public Person(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Person() {
    }



    //
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    @Override
//    public String toString() {
//        return "Person{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                '}';
//    }
}
	
	

