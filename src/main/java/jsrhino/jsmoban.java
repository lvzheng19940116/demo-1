package jsrhino;

import java.io.FileReader;
import java.net.URL;
import java.util.List;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class jsmoban {
	public static void main(String[] args) throws Exception {

		// 获得脚本引擎   jdk1.8 "println"改"print"
		ScriptEngineManager sem = new ScriptEngineManager();
		ScriptEngine engine = sem.getEngineByName("javascript");

		// 定义变量，存储引擎上下文中
		engine.put("msg", "gaoqi is a good man!");
		String str = "var user = {name:'gaoqi',age:18,schools:['清华','北大']};";
		str += "print(user.name);";
		str += "print(user.schools);";

		// ִ执行脚本
		engine.eval(str);
		engine.eval("msg = 'sxt is a good school';");
		System.out.println(engine.get("msg"));
		System.out.println("###########################");

		// 定义函数
		engine.eval("function add(a,b){var sum = a + b; return sum;}");
		// 取得调用接口
		Invocable jsInvoke = (Invocable) engine;
		// 执行脚本中定义的方法
		Object result1 = jsInvoke.invokeFunction("add", new Object[] { 13, 20 });
		System.out.println(result1);

		//倒入其他java包，使用其中的类
		//jdk1.6
		//String jsCode = "importPackage(java.util); var list=Arrays.asList([\"交大\",\"北大\",\"狗大\"]);";		
		//jdk1.8
		String jsCode = "var list = java.util.Arrays.asList([\"北京尚学堂\",\"清华大学\",\"北京大学\"]);";
		engine.eval(jsCode);

		List<String> list2 = (List<String>) engine.get("list");
		for (String temp : list2) {
			System.out.println(temp);
		}

		// 执行一个js文件，文件位于src下面
		URL url = jsmoban.class.getClassLoader().getResource("a.js");
		FileReader fr = new FileReader(url.getPath());
		engine.eval(fr);
		fr.close(); // 正式要使用try catch finally

	}

}
