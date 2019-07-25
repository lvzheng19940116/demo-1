package delspace;

/**
 * @author LvZheng
 * 创建时间：2019/7/15 5:17 PM
 */
public class DelSpace {



    public static void main(String[] args) {
        String s="aa(bb)cc（dd）ee";
        String s1 = s.replaceAll("（", "").replaceAll("）", "").replaceAll("\\(|\\)", "");
        System.out.println(s1);
    }
}
