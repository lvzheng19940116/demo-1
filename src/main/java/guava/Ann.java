package guava;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
*以动手实践为荣,以只看不练为耻.
*以打印日志为荣,以出错不报为耻.
*以局部变量为荣,以全局变量为耻.
*以单元测试为荣,以手工测试为耻.
*以代码重用为荣,以复制粘贴为耻.
*以多态应用为荣,以分支判断为耻.
*以定义常量为荣,以魔法数字为耻.
*以总结思考为荣,以不求甚解为耻.
*
* @author LvZheng
* 创建时间：2018年8月14日 上午9:14:36
* 自定义注解
*/

//@Target(value=ElementType.METHOD)//只能在方法上使用  value=ElementType.METHOD
@Target(value= {ElementType.METHOD,ElementType.TYPE,ElementType.FIELD})//定义多个
@Retention(RetentionPolicy.RUNTIME)//可以通过反射读取注解
public @interface Ann {
	String value()  default "";//默认值  default
//	int age() default 0;
//	int id() default -1; //表示不存在
//	String[] schools() default{"清华","北大"};
	//使用时可以赋值  @Ann(name="lv",id=1)
}
