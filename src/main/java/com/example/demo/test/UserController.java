package com.example.demo.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.example.demo.test1.Temp;
import com.example.demo.test1.TempRepository;

/**
 * @author LvZheng
 * 2018年1月19日下午3:22:43
 */
@RestController
public class UserController {
	@Autowired
	private UserRepository userService;
	
	@Autowired
	private TempRepository tempRepository;
	@Autowired
	private EmpRepository empRepository;
	
	/**
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value="get")
	public Object get(){
		User findOne = userService.findOne(1);
		/*String replaceFirst = findOne.getName().replaceFirst("^0*", "");
		//User findByid = userService.findByid("1");
		findOne.setName(replaceFirst);
		System.out.println(replaceFirst);*/
		//Emp findOne2 = empRepository.findOne(1);
		List<Emp> findAll = empRepository.findAll();
		String jsonString = JSON.toJSONString(findAll);
		//JSON.parse(jsonString);
		//JSON.stringify(jsonString);
		return findOne;
	}
	
	
	@PostMapping(value="save")
	
	public Object save(@RequestBody Emp emp){

		Emp save = empRepository.save(emp);
		
		return save;
	}
	
@PutMapping(value="up")
	
	public Object up(@RequestBody Emp emp){

		Emp save = empRepository.save(emp);
		
		return save;
	}
	
	@RequestMapping(value="get1/{name}/{age}")
	public List<User> get1(@PathVariable("name") String name ,@PathVariable("age") String age){
		List<User> findByLike = userService.findByLike(name, age);
		return findByLike;
	}
	@RequestMapping(value="get2")
	public List<User> get2(){
		String name ="380";
		String age= "";
		List<User> findByLike = userService.findByLike(name, age);
		return findByLike;
	}
	
	@RequestMapping(value="get3")
	public Temp get3(){
		Temp findOne = tempRepository.findOne(1);
		return findOne;
	}
	
}
