package single;

/**
 * 以动手实践为荣,以只看不练为耻. 以打印日志为荣,以出错不报为耻. 以局部变量为荣,以全局变量为耻. 以单元测试为荣,以手工测试为耻.
 * 以代码重用为荣,以复制粘贴为耻. 以多态应用为荣,以分支判断为耻. 以定义常量为荣,以魔法数字为耻. 以总结思考为荣,以不求甚解为耻.
 *
 * @author LvZheng 创建时间：2018年9月12日 上午9:35:51
 */
public enum SingletonEnum {
	
	
	//SingletonEnum.INSTANCE调用
	//枚举元素本身就是单例对象（没有延时加载）
	INSTANCE;
	//添加自己需要的操作
	public void test() {
		
	}
	
}
