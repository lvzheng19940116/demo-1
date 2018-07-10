package com.example.demo.test;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;


@Data
@Entity
public class User {
	@Id
	private int id;
	private String name;
	private String age;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List<Emp> list;
	
	
//	public List<Emp> getList() {
//		return list;
//	}
//	public void setList(List<Emp> list) {
//		this.list = list;
//	}
//	public int getId() {
//		return id;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public String getAge() {
//		return age;
//	}
//	public void setAge(String age) {
//		this.age = age;
//	}
//	@Override
//	public String toString() {
//		return "User [id=" + id + ", name=" + name + ", age=" + age + "]";
//	}
//	
	
	
}
