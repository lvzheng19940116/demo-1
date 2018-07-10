package ad.util;

import java.util.ArrayList;

public class sixNum {

	public static String sixNum(){
		//数组 
        int[] ary = new int[6];
        //集合
        ArrayList<Integer> list = new ArrayList<Integer>();
        //给集合添加1~10的数字
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        //循环10次，随即抽取集合的数字给数组
        for (int i = 0; i < 6; i++) {
            ary[i] = list.get((int)(Math.random()*10));
        }
        ///输出数组的元素
        String sixNum="";
        for (int i = 0; i < ary.length; i++) {
        	sixNum+=ary[i];
        }
        return sixNum;
	}
}
