package net.ityizhan.algorithm.basic.class5;

/**
 * @ClassName Code02BitAddMinusMultiDiv
 * @Description
 * @Author 骚豪 程序驿站: https://www.ityizhan.net
 * @Date 2021/6/29 17:04
 * @Version V1.0.0
 **/
public class Code02BitAddMinusMultiDiv {

    public static int add(int a, int b) {
        int sum = a;
        // 直到进位信息没有了  就是结果了
        while (b != 0) {
            // 获取a + b 无进位相加信息
            sum = a ^ b;
            // 获取a + b 的进位信息
            b = (a & b) << 1;
            a = sum;
        }
        return sum;
    }

    public static int negNum(int a) {
        return add(~a, 1);
    }

    public static int minus(int a, int b) {
        // a - b = a + b的相反数  负数的二进制相反数位 负数取反加1
        return add(a, negNum(b));
    }

    public static int multi(int a, int b) {
        int res = 0;
        while (b != 0) {
            if ((b & 1) != 0) {
                res = add(res, a);
            }
            a <<= 1;
            b >>>= 1;
        }
        return res;
    }

    public static boolean isNeg(int n) {
        return n < 0;
    }

    public static int div(int a, int b) {
        int x = isNeg(a) ? negNum(a) : a;
        int y = isNeg(b) ? negNum(b) : b;

        int res = 0;
        for (int i = 30; i >= 0; i = minus(i, 1)) {
            if ((x >> i) >= y) {
                res |= (1 << i);
                x = minus(x, y << i);
            }
        }
        return isNeg(a) ^ isNeg(b) ? negNum(res) : res;
    }


    public static void main(String[] args) {
        System.out.println(add(1, 5));
        System.out.println(minus(7, 5));
        System.out.println(multi(2, 5));
        System.out.println(multi(2, -5));
    }
}