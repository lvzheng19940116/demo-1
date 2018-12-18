package md5;

import org.apache.commons.codec.digest.DigestUtils;

import java.net.URLEncoder;

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
 * 创建时间：2018/10/17 上午10:02
 */
public class Md5Test {
    public static void main(String[] args) throws Exception {

        String encodeStr=DigestUtils.md5Hex("jd123456");
        System.out.println(encodeStr);
        String aaa=DigestUtils.md5Hex("w4lcjqtHFCUqHvluT8eZ2018-10-17 09:17:56PGLjA7gNCfUsxryKD3SD联想百应VOP745404feaba9fb037e01b4a91c6ddbebaccess_tokenw4lcjqtHFCUqHvluT8eZ");
        System.out.println(aaa);

        String VOP = URLEncoder.encode("联想百应VOP","utf-8");
        System.out.println(VOP);
    }
}
