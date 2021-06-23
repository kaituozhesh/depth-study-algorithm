package net.ityizhan.algorithm.basic.class1;

/**
 * @ClassName : Code02SumOfFactorial
 * @Description : 乘阶
 * @Author : 骚豪 : https://www.ityizhan.net
 * @Date: 2021-06-22 21:59
 * @Version: 1.0.0
 */
public class Code02SumOfFactorial {

    private static long f1(int n) {
        long ans = 0;
        for (int i = 1; i <= n; i++) {
            ans += factorial(i);
        }
        return ans;
    }

    private static long factorial(int n) {
        long ans = 1;
        for (int i = 1; i <= n; i++) {
            ans *= i;
        }
        return ans;
    }

    private static long f2(int n) {
        long ans = 0;
        long cur = 1;
        for (int i = 1; i <= n; i++) {
            cur = cur * i;
            ans += cur;
        }
        return ans;
    }


    public static void main(String[] args) {
        int n = 10;
        System.out.println(f1(n));
        System.out.println(f2(n));
    }
}
