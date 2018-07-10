/** 
 * @Title:统一异常类 
 * @Desription:统一异常类
 * @Company:CSN
 * @ClassName:AmmsException.java
 * @Author:Justic
 * @CreateDate:2015-2-3   
 * @UpdateUser:Justic  
 * @Version:0.1 
 *    
 */

package ad.util;

import java.util.Arrays;

/**
 * @ClassName: AmmsException
 * @Description: 统一异常类
 * @author: Justic
 * @date: 2018-2-3
 * 
 */
public class AdException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String key;// 保存信息代码

	private Object[] args;//信息参数

	public AdException(String key, Throwable cause) {
		super(key, cause);
		this.key = key;

	}

	public AdException(String key) {
		super(key);
		this.key = key;
	}

	public AdException(String key, Object... arguments) {
		super(key);
		this.key = key;
		this.args = arguments;
	}

	

	public AdException(String key, Throwable cause, Object... arguments) {
		this(key, cause);
		this.args = arguments;
	}


	/**
	 * 将参数[]转换为string返回显示
	 * 
	 * @return
	 */
	public String getArgsToString() {
		if (args == null || args.length <= 0) {
			return "";
		} else {
			return Arrays.toString(args);
		}
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Object[] getArgs() {
		return args;
	}

	public void setArgs(Object[] args) {
		this.args = args;
	}

	
	
	
}
