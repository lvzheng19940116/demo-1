package ann;

import java.lang.reflect.Method;

/**
 * 以动手实践为荣,以只看不练为耻. 以打印日志为荣,以出错不报为耻. 以局部变量为荣,以全局变量为耻. 以单元测试为荣,以手工测试为耻.
 * 以代码重用为荣,以复制粘贴为耻. 以多态应用为荣,以分支判断为耻. 以定义常量为荣,以魔法数字为耻. 以总结思考为荣,以不求甚解为耻.
 *
 * @author LvZheng 创建时间：2018年8月15日 上午9:27:22
 * 
 *         利用反射处理注解信息 模拟处理注解信息流程
 */
public class AnnTest {
	public static void main(String[] args) throws Exception {
		Class cls = Temp.class;
//		// 获取类所有注解
//		Annotation[] annotations = cls.getAnnotations();
//		for (Annotation annotation : annotations) {
//			System.out.println(annotation);
//		}
//		// 获取类的指定注解
//		Ann annotation = (Ann) cls.getAnnotation(Ann.class);
//		System.out.println("----"+annotation.value());
//		// 获取类属性
//		Field declaredField = cls.getDeclaredField("id");
//		Ann annotation2 = declaredField.getAnnotation(Ann.class);
//		System.out.println(annotation2.value());
//		// getDeclaredMethod可以获取到所有方法，而getMethod只能获取public
//		//Field field = personType.getDeclaredField("name");
//		// 取消对访问控制修饰符的检查
//		//field.setAccessible(true);

		System.out.println("________________");
		Method method1 = cls.getMethod("add");
		System.out.println("1"+method1);
		Method method2 =cls.getDeclaredMethod("add");
		System.out.println("1"+method2);
	}
}