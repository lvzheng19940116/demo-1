package com.example.demo.test1;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Temp {
	@Id
	private int id;
	private String status;
	private String sex;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
}
