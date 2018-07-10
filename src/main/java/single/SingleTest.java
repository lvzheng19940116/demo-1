package single;

/**
 * 以动手实践为荣,以只看不练为耻. 以打印日志为荣,以出错不报为耻. 以局部变量为荣,以全局变量为耻. 以单元测试为荣,以手工测试为耻.
 * 以代码重用为荣,以复制粘贴为耻. 以多态应用为荣,以分支判断为耻. 以定义常量为荣,以魔法数字为耻. 以总结思考为荣,以不求甚解为耻.
 *
 * @author LvZheng 创建时间：2018年6月11日 上午9:15:29
 */
public class SingleTest {

	// 单例模式 懒汉
	private static SingleTest instance = null;

	private SingleTest() {
	};

	// 锁的模板
	// 经典的 双重检查
	public static SingleTest getInstance() {
		// abc 提高已经存在对象的效率
		if (null == instance) {
			// a 创建对象
			synchronized (SingleTest.class) {
				if (null == instance) {
					instance = new SingleTest();
				}
			}
		} // bc直接获取
		return instance;
	}
}

class SingleTest1 {
	// 单例模式 饿汉
	private static SingleTest1 instance = new SingleTest1();

	private SingleTest1() {
	};

	public static SingleTest1 getInstance() {

		return instance;
	}
}

class SingleTest2 {
	// 加强版饿汉模式
	// 类在使用的时候加载 延缓类的加载 属性一定会初始化
	private static class SingleTestHolder {
		// 单例模式 饿汉
		private static SingleTest2 instance = new SingleTest2();
	}

	private SingleTest2() {
	};

	public static SingleTest2 getInstance() {

		return SingleTestHolder.instance;
	}
}
