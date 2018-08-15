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
	private String sex;
	private String hobby;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List<Emp> list;
	
	
}
