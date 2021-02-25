package paramdefault;

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
 * 创建时间：2018/11/12 下午4:04
 */
public class DefaultParameter {

    /**
     * java默认参数
     *
     * @param givenName
     * @param familyName
     * @return
     */
    public String getName(String givenName, String familyName) {
        return givenName + "." + familyName;
    }

    public String getName(String givenName) {
        return getName(givenName, "Xie");
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //java默认参数
        DefaultParameter parameterDefault = new DefaultParameter();
        System.out.println(parameterDefault.getName("AAA"));
        System.out.println(parameterDefault.getName("AAA", "Liu"));

        //java 可变参数
        System.out.println(parameterDefault.get());
    }

    /**
     * java 可变参数
     *
     * @param str
     * @return
     */
    public String add(String... str) {
        return "true";
    }

    public String get() {
        String add = this.add("aaa");
        String add1 = this.add();
        return add;
    }


}
