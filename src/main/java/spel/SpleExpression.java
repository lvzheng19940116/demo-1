package spel;

import com.example.demo.test.Person;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * 以动手实践为荣,以只看不练为耻.
 * 以打印日志为荣,以出错不报为耻.
 * 以局部变量为荣,以全局变量为耻.
 * 以单元测试为荣,以手工测试为耻.
 * 以代码重用为荣,以复制粘贴为耻.
 * 以多态应用为荣,以分支判断为耻.
 * 以定义常量为荣,以魔法数字为耻.
 * 以总结思考为荣,以不求甚解为耻.
 *
 * @author LvZheng
 * 创建时间：2018/11/27 下午3:15
 */
public class SpleExpression {
    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();
        //字符串需要加 ''  单引号表示String类型
        Expression lvZheng = parser.parseExpression("'LvZheng'");
        String expressionString = lvZheng.getExpressionString();
        System.out.println(expressionString);
        String value = lvZheng.getValue(String.class);
        System.out.println(value);

        //使用SpEL来计算评估 bean 属性 – “person.name”.
        Person person = new Person(1L, "HaoXUeYun");
        StandardEvaluationContext context = new StandardEvaluationContext(person);
        String name = parser.parseExpression("name").getValue(context, String.class);
        System.out.println(name);

        //解析字符串
        String value1 = parser.parseExpression("\"Hellow\"").getValue(String.class);
        System.out.println(value1);
        //解析双精度浮点型
        Double dou = parser.parseExpression("6.43214E+23").getValue(Double.class);
        System.out.println(dou);
        //解析整形
       // Integer integer = parser.parseExpression("0 7FFFFFFF").getValue(Integer.class);
       // System.out.println(integer);
        //解析整形布尔形
        Boolean boo = parser.parseExpression("true").getValue(Boolean.class);
        System.out.println(boo);
        //解析null
        String n = parser.parseExpression("null").getValue(String.class);
        System.out.println(n);





    }
}
