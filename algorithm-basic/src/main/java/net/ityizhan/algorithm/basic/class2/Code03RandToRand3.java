package net.ityizhan.algorithm.basic.class2;

/**
 * @ClassName Code03RandToRand3
 * @Description 相等概率随机
 * @Author 程序驿站: https://www.ityizhan.net
 * @Date 2021/6/23 14:03
 * @Version V1.0.0
 **/
public class Code03RandToRand3 {
    public static void main(String[] args) {
        int testTimes = 1000000;
        int count = 0;
        for (int i = 0; i < testTimes; i++) {
            if (y() == 0) {
                count++;
            }
        }
        System.out.println((double) count / (double) testTimes);
    }

    /**
     * 假设你只能知道x会以固定概率返回 0 和 1，但x的内容，你看不到
     *
     * @return
     */
    public static int x() {
        return Math.random() < 0.84 ? 0 : 1;
    }

    /**
     * 只能借助x函数返回等概率0 和 1
     *
     * @return
     */
    public static int y() {
        int ans = 0;
        do {
            ans = x();
        } while (ans == x());
        return ans;
    }
}