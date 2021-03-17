package factorial;

/**
 * @author LvZheng
 * 创建时间：2021/3/17 下午2:37
 */
public class FactorialDemo {
    //递归实现n的阶乘
    //要接收一个参数，应该定义参数类型和名字 int i
    //需要n的阶乘，是一个数字，应该有返回值，返回值类型int
    public static long factorial(long n) {
        if (n == 1) {
            return 1;
        } else {
            long i = n * factorial(n - 1);
            System.out.println(i);
            return i;
        }
    }

    public static long factorial(long n, long k) {
        if (k == 1) {
            return 1;
        } else {
            long i = n * factorial(n, k - 1);
            System.out.println(i);
            return i;
        }
    }


    //主方法
    public static void main(String[] args) {
        long num = 3L;
        long ret = factorial(num, num);//调用阶乘方法
        System.out.println(num + "的阶乘为" + ret);//输出返回值
    }


    /**
     * 递归几次就有多大的复杂度，最多递归次数是n为负数且n为奇数的时候，比n为正数且为偶数的情况多递归2次，常数级别的复杂度忽略不计；主要就看n为偶数的时候，这时       最多递归次数为n的二进制位数，也就是lognlogn(底数为2)。时空复杂度差不多是这个水平
     * <p>
     * 作者：edelweisskoko
     * 链接：https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/solution/jian-zhi-offer-16-shu-zhi-de-zheng-shu-c-rgqy/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        } else if (n < 0) {
            double v = 1 / (x * myPow(x, -n - 1));
            System.out.println("n < 0:" + v);
            return v;
        } else if (n % 2 == 1) {
            int i = n % 2;
            System.out.println("n % 2=:" + i);
            double v = x * myPow(x, n - 1);
            System.out.println("n % 2 == 1:" + v);
            return v;
        } else {
            double v = myPow(x * x, n / 2);
            System.out.println("else:" + v);
            return v;
        }
    }


    /**
     * 首先处理一下n为负数的情况，把x取一下倒数并且把n变为正数即可
     * <p>
     * 接下来以n = 18为例解释一下迭代的过程
     * 18 的二进制数为 0b10010（0b开头表示二进制数）18的二进制数为0b10010（0b开头表示二进制数）
     * 令循环体为 x *= x，n >>= 1令循环体为x∗=x，n>>=1
     * 循环1次可以得到x ^ 2
     * 循环2次的时候n为奇数，把这个x ^ 2 乘到结果中
     * 循环4次可以得到 x ^ {16}
     * 循环5次的时候n为奇数，把x ^ {16}
     * 乘到结果中
     * 也就是n的二进制数中有几个1就会乘几次，且乘数在循环中一次一次倍增也就是n的二进制数中有几个1就会乘几次，且乘数在循环中一次一次倍增
     * 作者：edelweisskoko
     * 链接：https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/solution/jian-zhi-offer-16-shu-zhi-de-zheng-shu-c-rgqy/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow1(double x, int n) {
        long b = n;
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        double res = 1;
        while (b != 0) {
            if (b % 2 != 0) {
                res *= x;
            }
            b >>= 1;
            x *= x;
        }
        return res;
    }

}
