package substring;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author LvZheng
 * 创建时间：2019/12/31 11:30 AM
 */
public class SubString {
    public static void main(String[] args) {
        String str ="SMB123X";

        String s = str.substring(0, 3);
        System.out.println(s);
        String a = str.substring(str.length() - 1,str.length());
        System.out.println(a);


        List<String>  list1= Lists.newArrayList("5","7","3");


        List<String>  list2= Lists.newArrayList("3","5","7");

        for (int i = 0; i <list1.size() ; i++) {

            for (int j = 0; j <list2.size() ; j++) {

                if(list1.get(i).equals(list2.get(j))){
                    System.out.println(list1.get(i)+list2.get(j));
                }
            }

        }


    }
}
