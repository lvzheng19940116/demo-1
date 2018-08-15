package com.example.demo.test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

/**
 * @author LvZheng 创建时间：2018年1月19日 下午3:32:06 项目名称：demo-1
 * @version 1.0
 * @since JDK 1.8 文件名称：cccc.java
 */
@Data
@Entity
public class Emp {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int eid;
	private String name;
	private String sect;
	private String effort;
    @CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(updatable = false)
	private Date date1;
	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	private Date date2;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = true)
	@JoinColumn(name = "ttt",insertable = false, updatable = false)
	@JsonBackReference
	private User user;
//	public static void main(String[] args) throws Exception, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
//		Emp emp=new Emp();
//		emp.setEid(1);
//		emp.setName("吕正");
//		System.out.println(emp);
//		Class<? extends Emp> class1 = emp.getClass();
//		Field declaredField = class1.getDeclaredField("name");
//		String object = (String)declaredField.get(emp);
//		System.out.println(object);
//	}
}
