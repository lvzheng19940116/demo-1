package base64;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

/**
 * @author LvZheng
 * 创建时间：2020/6/1 3:19 下午
 */
public class Base64 {
    public static void main(String[] args) {

      //  Assert.isTrue(1==2,"请填写密码");
        String code = String.valueOf((Math.random() * 9 + 1) * 100000).substring(0,6);
        System.out.println(code);
//        String password="China123!";
//        String bs64Pwd = java.util.Base64.getEncoder().encodeToString(password.getBytes());
//        System.out.println(bs64Pwd);
//        String bs64Pwd2 = java.util.Base64.getEncoder().encodeToString(bs64Pwd.getBytes());
//        System.out.println(bs64Pwd2);

//        List<BigDecimal> list  = Lists.newArrayList(new BigDecimal("-1"),new BigDecimal("1"));
//        BigDecimal bigDecimal = list.stream().max(Comparator.comparing(BigDecimal::abs)).get();
//        System.out.println(bigDecimal);


        SecureRandom random = new SecureRandom();
//        try {
//            random = SecureRandom.getInstance("SHA1PRNG");
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        }
        byte[] bytes = new byte[16];
        random.nextBytes(bytes);
        String s = java.util.Base64.getEncoder().encodeToString(bytes);
        System.out.println(s);

      //  String lvzheng = getPBKDF2("lvzheng", "vYo2Oavz+8OoZZW7MbPzKA==");
        String lvzheng = getPBKDF2("B2Bdemo", "0d8n5BuWeX3eabgW9fhnAA==");
        System.out.println(lvzheng);

    }

    /**
     * 支持的算法:
     * DES
     * DESede
     * PBE
     * PBEWithMD5AndDES
     * PBEWithMD5AndTripleDES
     * PBEWithSHA1AndDESede
     * PBEWithSHA1AndRC2_40
     * PBEWithSHA1AndRC2_128
     * PBEWithSHA1AndRC4_40
     * PBEWithSHA1AndRC4_128
     * PBEWithHmacSHA1AndAES_128
     * PBEWithHmacSHA224AndAES_128
     * PBEWithHmacSHA256AndAES_128
     * PBEWithHmacSHA384AndAES_128
     * PBEWithHmacSHA512AndAES_128
     * PBEWithHmacSHA1AndAES_256
     * PBEWithHmacSHA224AndAES_256
     * PBEWithHmacSHA256AndAES_256
     * PBEWithHmacSHA384AndAES_256
     * PBEWithHmacSHA512AndAES_256
     * PBKDF2WithHmacSHA1
     * PBKDF2WithHmacSHA224
     * PBKDF2WithHmacSHA256
     * PBKDF2WithHmacSHA384
     * PBKDF2WithHmacSHA512
     * @param password
     * @param salt
     * @return
     */
    public static String getPBKDF2(String password,  String  salt)  {
        //将16进制字符串形式的salt转换成byte数组
        byte[] bytes = java.util.Base64.getDecoder().decode(salt);
        KeySpec spec = new PBEKeySpec(password.toCharArray(), bytes, 10000, 256 );
        SecretKeyFactory secretKeyFactory = null;
        try { //PBKDF2WithHmacSHA1  PBKDF2WithHmacSHA256
            secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte[] hash = new byte[0];
        try {
            hash = secretKeyFactory.generateSecret(spec).getEncoded();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
        //将byte数组转换为16进制的字符串
        return java.util.Base64.getEncoder().encodeToString(hash);
    }


}
