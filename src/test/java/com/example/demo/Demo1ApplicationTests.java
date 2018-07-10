package com.example.demo;

import java.text.Collator;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.test.Person;



@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo1ApplicationTests {

	@Test
	public void contextLoads() {
	}
	
	
	 @Test
	    public void testSort() {
	        Person p1 = new Person(1l, "周杰伦");
	        Person p2 = new Person(3l, "刘德华");
	        Person p3 = new Person(2l, "张学友");
	        Person p4 = new Person(4l, "成龙");
	        Person p5 = new Person(5l, "胶布虫");

	        List<Person> persons = Arrays.asList(p1, p2, p3, p4, p5);

	        Collections.sort(persons, new Comparator<Person>() {
	            @Override
	            public int compare(Person o1, Person o2) {
	                Collator collator = Collator.getInstance(Locale.CHINA);
	                return collator.compare(o1.getName(), o2.getName());
	            }
	        });
	        System.out.println(persons);
	    }

	 
	 

	 
	 
	 
	 
	 
}
