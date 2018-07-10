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
*@author： LvZheng
* 创建时间：2018年5月30日 下午6:47:19
 */
public class DeptManager extends Handler{

	@Override
	public String handleRequest(String user, int fee) {
		  String str = "";
	        //部门经理的权限只能在1000以内
	        if(fee < 1000)
	        {
	            //为了测试，简单点，只同意张三的请求
	            if("张三".equals(user))
	            {
	                str = "成功：部门经理同意【" + user + "】的聚餐费用，金额为" + fee + "元";    
	            }else
	            {
	                //其他人一律不同意
	                str = "失败：部门经理不同意【" + user + "】的聚餐费用，金额为" + fee + "元";
	            }
	        }else
	        {
	            //超过1000，继续传递给级别更高的人处理
	            if(getSuccessor() != null)
	            {
	                return getSuccessor().handleRequest(user, fee);
	            }
	        }
	        return str;
	    }

}
