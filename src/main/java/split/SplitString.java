package split;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

/**
 * @author LvZheng
 * 创建时间：2019/7/31 5:15 PM
 */
public class SplitString {
    public static void main(String[] args) {
        String report = "1564561301612,323,HTTP请求,403,,base-accounts-controller-汇入行 1-24,text,false,,266,567,56,133,http://10.122.30.26:8888/accounts/bbknbr,323,0,151\n" +
                "1564561301867,72,HTTP请求,403,,base-accounts-controller-汇入公司 2-34,text,false,,266,567,41,133,http://10.122.30.26:8888/accounts/soname,67,0,17";

        Set<A> a=new HashSet<>();
        String[] split = report.split("\n");
        System.out.println(split.length);
        for (int i = 0; i < split.length; i++) {

            System.out.println("one：" + split[i]);
            String s = split[i];
            String[] split1 = s.split("HTTP请求");
            for (int i1 = 0; i1 < split1.length; i1++) {
                System.out.println("two：" + split1[i1]);
                if (i1 % 2 != 0) {
                    String s1 = split1[i1];
                    System.out.println("three：" +s1);

                    String[] split2 = s1.split(",");
                    for (int i2 = 0; i2 < split2.length; i2++) {
                        A aa=new A();
                        aa.setStatus(split2[1]);
                        aa.setName(split2[3]);
                        a.add(aa);
                        System.out.println("four:"+split2[i2]);
                    }

                }

            }

        }

        System.out.println("end:"+a);
    }

    @Data
  static   class A{

        private  String status;
        private  String name;
        private  String flag;
        private  String url;

    }


}
