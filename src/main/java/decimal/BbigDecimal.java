package decimal;

import java.math.BigDecimal;

/**
 * @author LvZheng
 * 创建时间：2018年3月27日 下午4:36:14
 */
public class BbigDecimal {
    public static void main(String[] args) {
        BigDecimal b = new BigDecimal(100.5);
        //保留2位小数
        BigDecimal setScale = b.setScale(2, BigDecimal.ROUND_HALF_UP);
        System.out.println(setScale);  //111231.56
        /**
         *Math.sqrt()//计算平方根
         *Math.cbrt()//计算立方根
         *Math.pow(a, b)//计算a的b次方
         *Math.max( 2.3,4.5 );//计算最大值
         *Math.min( 2.3,4.5 );//计算最小值
         *Math.abs(-10.4)  abs求绝对值
         *Math.ceil(-10.1);   //-10.0   ceil天花板的意思，就是返回大的值
         *Math.floor(-10.1);  //-11.0  floor地板的意思，就是返回小的值
         * Math.random();  //小于1大于0的double类型的数
         * Math.random()*2+1;//大于1小于2的double类型的数
         * Math.rint(10.1); //10 rint 四舍五入，返回double值 * 注意.5的时候会取偶数    异常的尴尬=。=
         * Math.round(10.1); //10    round 四舍五入，float时返回int值，double时返回long值
         */

        double sqrt = Math.sqrt(2);
        System.out.println(sqrt);

//	    double num = 111231.5585;  
//	    BigDecimal b = new BigDecimal(num);  
//	    //保留2位小数  
//	    double result = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();  
//	    System.out.println(result);  //111231.56 
    }
}
