package net.ityizhan.algorithm.basic.class2;

/**
 * @ClassName Code02RandToRand
 * @Description
 * @Author 程序驿站: https://www.ityizhan.net
 * @Date 2021/6/23 10:52
 * @Version V1.0.0
 **/
public class Code02RandToRand {


    public static void main(String[] args) {
        // Math.random() -> double -> 返回一个[0, 1)的等概率小数
        // double ans = Math.random();

        // 测试等概率问题
        int testTimes = 1000000;
        int count = 0;
        for (int i = 0; i < testTimes; i++) {
            if (Math.random() < 0.75) {
                count++;
            }
        }
        System.out.println("[0, 1) < 0.75 占比：" + (double) count / (double) testTimes);

        count = 0;
        for (int i = 0; i < testTimes; i++) {
            if (Math.random() * 8 < 4) {
                count++;
            }
        }
        System.out.println("[0, 8) < 4 占比：" + (double) count / (double) testTimes);

        int k = 9;
        int[] counts = new int[9];
        for (int i = 0; i < testTimes; i++) {
            int ans = (int) (Math.random() * k);
            counts[ans]++;
        }
        for (int i = 0; i < counts.length; i++) {
            System.out.println(i + " 出现了 " + counts[i] + " 次");
        }

        System.out.println();

        count = 0;
        double x = 0.7;
        for (int i = 0; i < testTimes; i++) {
            if (xToXPower2() < x) {
                count++;
            }
        }
        System.out.println("[0, 1) < 0.7 占比：" + (double) count / (double) testTimes);
        System.out.println(Math.pow(x, 2));
    }

    /**
     * 返回[0,1)的一个小数
     * 任意的x，x属于[0,1)范围上的数出现概率由原来的x调整成x平方
     *
     * @return
     */
    public static double xToXPower2() {
        return Math.max(Math.random(), Math.random());
    }

}