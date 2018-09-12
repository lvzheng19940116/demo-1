package staticclass;

/**
 * 以动手实践为荣,以只看不练为耻. 以打印日志为荣,以出错不报为耻. 以局部变量为荣,以全局变量为耻. 以单元测试为荣,以手工测试为耻.
 * 以代码重用为荣,以复制粘贴为耻. 以多态应用为荣,以分支判断为耻. 以定义常量为荣,以魔法数字为耻. 以总结思考为荣,以不求甚解为耻.
 *
 * @author LvZheng 创建时间：2018年9月7日 上午9:32:26
 */
public class ClassStatic {
	// 静态内部类
	private static class name {

	}

	// 普通内部类（成员内部类）
	private class name1 {

	}

	// 方法内部类（局部内部类）
	public void name() {

		class lvclass {

		}

		// 匿名内部类  （方法内部类）
		Runnable runnable = new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub

			}
		};
	}

	// 匿名内部类（成员内部类）
	Runnable runnable = new Runnable() {

		@Override
		public void run() {
			// TODO Auto-generated method stub

		}
	};

}
