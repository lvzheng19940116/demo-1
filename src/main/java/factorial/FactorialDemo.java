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
        long ret = factorial(num,num);//调用阶乘方法
        System.out.println(num + "的阶乘为" + ret);//输出返回值
    }
}
