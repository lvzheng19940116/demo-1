package bigSmall;

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
	    
	    
//	    double num = 111231.5585;  
//	    BigDecimal b = new BigDecimal(num);  
//	    //保留2位小数  
//	    double result = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();  
//	    System.out.println(result);  //111231.56 
	}
}
