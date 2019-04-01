package com.example.demo.test;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author LvZheng 创建时间：2018年1月19日 下午3:32:06 项目名称：demo-1
 * @version 1.0
 * @since JDK 1.8 文件名称：cccc.java
 */
@Data
@Entity
public class Emp implements Serializable {

	private static final long serialVersionUID = -8539473991636693897L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	/**
	 * @GeneratedValue注解的strategy属性提供四种值：
	 *
	 * –AUTO： 主键由程序控制，是默认选项，不设置即此项。
	 *
	 * –IDENTITY：主键由数据库自动生成，即采用数据库ID自增长的方式，Oracle不支持这种方式。
	 *
	 * –SEQUENCE：通过数据库的序列产生主键，通过@SequenceGenerator 注解指定序列名，mysql不支持这种方式。
	 *
	 * –TABLE：通过特定的数据库表产生主键，使用该策略可以使应用更易于数据库移植。
	 */
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
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
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
