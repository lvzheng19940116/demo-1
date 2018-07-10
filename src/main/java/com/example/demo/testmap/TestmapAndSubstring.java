package com.example.demo.testmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TestmapAndSubstring {
	/*public static void main(String[] args) {
		String str ="this is a cat and that is a mice and where is the food";
		//分割字符串
		String[] strArray=str.split(" ");
		//存储到Map中
		Map<String,Letter>  letters = new HashMap<String,Letter>();
		for(String temp:strArray){			
			
			 //1、为所有key创建容器		 
			if(!letters.containsKey(temp)){
				Letter col = new Letter();
				col.setCount(1); //第一次值存放容器中
				letters.put(temp, col);
			}else{
				//2、	 第二次之后，直接使用容器存放值
				Letter col =letters.get(temp); //直接使用容器
				col.setCount(col.getCount()+1);
			}
			
			Letter letter = letters.get(temp);
			
			System.out.print("---"+letter+"---");
			
			
			Letter col = null;
			if(null==(col=letters.get(temp))){
				col = new Letter();
				col.setCount(1); //第一次值存放容器中
				letters.put(temp, col);
			}else{ 
				//2、	 第二次之后，直接使用容器存放值				
				col.setCount(col.getCount()+1);
			}
		}
		//输出Map的值
		Set<String> keys = letters.keySet();
		for(String key:keys){
			Letter col =letters.get(key);
			System.out.println("字母:"+key+",次数"+col.getCount());
		}
		//街区字符串
		 String rv = "";
		 String num="1234567890000";
	     if (num != null)
	     {
	         if (num.length() >= 12)
	         {
	             rv = num.substring(9);
	         }
	         else
	         {
	             rv = num;
	         }
	     }
	     System.out.println(rv);
*/
		
	//}
	public static void test1(){
		String str ="this is a cat and that is a mice and where is the food";
		//分割字符串
		String[] strArray=str.split(" ");
		//存储到Map中
		Map<String,Letter>  letters = new HashMap<String,Letter>();
		/*
		for(String temp:strArray){
			
			 //1、为所有key创建容器
			 	 之后容器中存放对应value
			 
			if(!letters.containsKey(temp)){
				letters.put(temp, new Letter());
			}
		}
		for(String temp:strArray){
			
			//  容器中存放对应value
			
			Letter col =letters.get(temp); //直接使用容器
			col.setCount(col.getCount()+1);
		}
		
		*/
		for(String temp:strArray){
			
			 //1、为所有key创建容器		 
			if(!letters.containsKey(temp)){
				letters.put(temp, new Letter());
			}
			//2、	 之后容器中存放对应value
			Letter col =letters.get(temp); //直接使用容器
			col.setCount(col.getCount()+1);
		}
		
		//输出Map的值
		Set<String> keys = letters.keySet();
		for(String key:keys){
			Letter col =letters.get(key);
			System.out.println("字母:"+key+",次数"+col.getCount());
		}
	}
	
	public void listAndMap(){
        Map<String, String> map = new HashMap<String, String>();    
        map.put("A", "ABC");    
        map.put("K", "KK");    
        map.put("L", "LV");    
          
        // 将Map Key 转化为List      
        List<String> mapKeyList = new ArrayList<String>(map.keySet());    
        System.out.println("mapKeyList:"+mapKeyList);  
          
        // 将Map Key 转化为List      
        List<String> mapValuesList = new ArrayList<String>(map.values());    
        System.out.println("mapValuesList:"+mapValuesList);  
	}
	
}

