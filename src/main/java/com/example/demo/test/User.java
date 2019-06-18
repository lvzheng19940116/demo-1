package com.example.demo.test;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;


@Data
@Entity
public class User {
	@Id
	private Integer id;
	private String name;
	private String age;
	private String sex;
	private String hobby;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List<Emp> list;
	
	
}
