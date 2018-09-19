package regex;

import java.util.Random;
import java.util.regex.Pattern;

/**
 * 以动手实践为荣,以只看不练为耻. 以打印日志为荣,以出错不报为耻. 以局部变量为荣,以全局变量为耻. 以单元测试为荣,以手工测试为耻.
 * 以代码重用为荣,以复制粘贴为耻. 以多态应用为荣,以分支判断为耻. 以定义常量为荣,以魔法数字为耻. 以总结思考为荣,以不求甚解为耻.
 *
 * @author LvZheng 创建时间：2018年7月26日 下午3:38:07
 */
public class RegexTest {
	public static void main(String[] args) {
		String knights = "AAA";
		// 构造匹配的正则表达式，也叫匹配文本模式,^叫行开头，^[A-Z]表示行开头以大写字母a-z的字母开始，
		// 中间是.*表示：.表示任意字符,*表示0到任意多个；最后[\\.]$表示结尾以.结尾，同时用了转移\\.对.符号转义。
		// 因为正则表达式里面.是代表任意字符的。所以要表示字面意思句号需要转义
//		String regex = "^[A-Z].*[\\.]$";
		String regex = "[A-Z].*";
		// 通过pattern类的静态函数matchs去判定字符串是否满足这样一个条件
		System.out.println(Pattern.matches(regex, knights));
		// 输出结果是true


		Random r=new Random(10);

		int i = r.nextInt(10);
		System.out.println(i);


	}
}
