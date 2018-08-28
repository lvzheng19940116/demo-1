package javassist;

/**
 * 以动手实践为荣,以只看不练为耻. 以打印日志为荣,以出错不报为耻. 以局部变量为荣,以全局变量为耻. 以单元测试为荣,以手工测试为耻.
 * 以代码重用为荣,以复制粘贴为耻. 以多态应用为荣,以分支判断为耻. 以定义常量为荣,以魔法数字为耻. 以总结思考为荣,以不求甚解为耻.
 *
 * @author LvZheng 创建时间：2018年8月28日 上午9:54:01
 * 
 * 操作字节码
 */
public class JavaAssistT {

	public static void main(String[] args) throws Exception {
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.makeClass("com.example.demo.test");

		// 创建属性
		CtField f1 = CtField.make("private int empno;", cc);
		CtField f2 = CtField.make("private String ename;", cc);
		cc.addField(f1);
		cc.addField(f2);

		// 创建方法
		CtMethod m1 = CtMethod.make("public int getEmpno(){return empno;}", cc);
		CtMethod m2 = CtMethod.make("public void setEmpno(int empno){this.empno=empno;}", cc);
		cc.addMethod(m1);
		cc.addMethod(m2);

		// 添加构造器
		CtConstructor constructor = new CtConstructor(new CtClass[] { CtClass.intType, pool.get("java.lang.String") },
				cc);
		constructor.setBody("{this.empno=empno; this.ename=ename;}");
		cc.addConstructor(constructor);

		//cc.writeFile("c:/myjava"); // 将上面构造好的类写入到c:/myjava中
		System.out.println("生成类，成功！");
	}
}
