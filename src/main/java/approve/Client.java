package approve;
/**
 * 
*以动手实践为荣,以只看不练为耻.
*以打印日志为荣,以出错不报为耻.
*以局部变量为荣,以全局变量为耻.
*以单元测试为荣,以手工测试为耻.
*以代码重用为荣,以复制粘贴为耻.
*以多态应用为荣,以分支判断为耻.
*以定义常量为荣,以魔法数字为耻.
*以总结思考为荣,以不求甚解为耻.
* 
*@author LvZheng
* 创建时间：2018年5月17日 下午2:41:05
 */
public class Client {
	public static void main(String[] args) {
	    //先要组装责任链
        Handler h1 = new GeneralManager();
        Handler h2 = new DeptManager();
        Handler h3 = new ProjectManager();
        h3.setSuccessor(h2);
        h2.setSuccessor(h1);
        
        
        
        String test1 = h3.handleRequest("张三", 300);
        System.out.println("test1 = " + test1);
        String test2 = h3.handleRequest("李四", 300);
        System.out.println("test2 = " + test2);
        System.out.println("---------------------------------------");
        
        String test3 = h3.handleRequest("张三", 700);
        System.out.println("test3 = " + test3);
        String test4 = h3.handleRequest("李四", 700);
        System.out.println("test4 = " + test4);
        System.out.println("---------------------------------------");
        
        String test5 = h3.handleRequest("张三", 1500);
        System.out.println("test5 = " + test5);
        String test6 = h3.handleRequest("李四", 1500);
        System.out.println("test6 = " + test6);
        
        
        
	}
}
