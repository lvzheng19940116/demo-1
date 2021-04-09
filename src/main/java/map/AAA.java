package map;

/**
 * @author LvZheng
 * 创建时间：2021/4/1
 */
public class AAA {

        public static void changeStringBuffer(StringBuffer m, StringBuffer n) {
            m.append(" world");
            n = m;
        }

    public static void main(String[] args) {
        final StringBuffer str_m = new StringBuffer("Hello");
        StringBuffer str_n =new StringBuffer("Hello");
        changeStringBuffer(str_m, str_n);
        System.out.println();
        System.out.println(str_m);
        System.out.println(str_n);
    }

}
