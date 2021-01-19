package transposing;

/**
 * @author LvZheng
 * @date 2021/1/19
 */
public class Transposing {
    public static void main(String[] args) {
        /**
         * 简单理解：
         *
         *  << 1  相当于乘以2
         *
         *  >> 1  相当于除以2
         *
         *    >>> 不考虑高位的正负号，正数的 >>> 等同于 >>
         *    >>>表示无符号右移，也叫逻辑右移，即若该数为正，则高位补0，而若该数为负数，则右移后高位同样补0
         */
        System.out.println("16 << 1 : " + (16 << 1));
        System.out.println("16 >> 3 : " + (16 >> 3));
        System.out.println("16 >> 10 : " + (16 >> 10));
        System.out.println("1 >> 1 : " + (1 >> 1));
        System.out.println("-16 >> 2 : " + (-16 >> 2));
        System.out.println("-16 << 2 : " + (-16 << 2));
        System.out.println("16 >> 2 : " + (16 >> 2));
        System.out.println("16 >>> 2 : " + (16 >>> 2));
        System.out.println("-16 >>> 2 : " + (-16 >>> 2));
    }
}
