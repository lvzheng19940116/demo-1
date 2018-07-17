package untils;
/**
*以动手实践为荣,以只看不练为耻.
*以打印日志为荣,以出错不报为耻.
*以局部变量为荣,以全局变量为耻.
*以单元测试为荣,以手工测试为耻.
*以代码重用为荣,以复制粘贴为耻.
*以多态应用为荣,以分支判断为耻.
*以定义常量为荣,以魔法数字为耻.
*以总结思考为荣,以不求甚解为耻.
*
* @author LvZheng
* 创建时间：2018年7月12日 下午4:04:19
*/
public class code {
public static void main(String[] args) {
	String str="abc";
	 String encode = "GB2312";      
    try {      
        if (str.equals(new String(str.getBytes(encode), encode))) {      
             String s = encode;      
            return;      
         }      
     } catch (Exception exception) {      
     }      
     encode = "ISO-8859-1";      
    try {      
        if (str.equals(new String(str.getBytes(encode), encode))) {      
             String s1 = encode;      
            return ;      
         }      
     } catch (Exception exception1) {      
     }      
     encode = "UTF-8";      
    try {      
        if (str.equals(new String(str.getBytes(encode), encode))) {      
             String s2 = encode;      
            return ;      
         }      
     } catch (Exception exception2) {      
     }      
     encode = "GBK";      
    try {      
        if (str.equals(new String(str.getBytes(encode), encode))) {      
             String s3 = encode;      
            return ;      
         }      
     } catch (Exception exception3) {      
     } 
}
}
