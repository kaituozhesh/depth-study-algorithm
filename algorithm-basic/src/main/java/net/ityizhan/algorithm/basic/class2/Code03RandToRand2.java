package net.ityizhan.algorithm.basic.class2;

/**
 * @ClassName Code03RandToRand2
 * @Description 对已知返回等概率的函数做适配，返回指定范围内的等概率
 * @Author 程序驿站: https://www.ityizhan.net
 * @Date 2021/6/23 13:13
 * @Version V1.0.0
 **/
public class Code03RandToRand2 {

    public static void main(String[] args) {

        int count = 0;
        int testTimes = 1000000;
        for (int i = 0; i < testTimes; i++) {
            if (a() == 0) {
                count++;
            }
        }
        System.out.println((double) count / (double) testTimes);

        int[] counts = new int[233];
        for (int i = 0; i < testTimes; i++) {
            int num = c(17, 232);
            counts[num]++;
        }
        for (int i = 0; i < counts.length; i++) {
            System.out.println(i + " 出现了 " + counts[i] + " 次");
        }
    }

    /**
     * 假设此函数是不能修改的，只能使用
     * 等概率返回1 ~ 5
     *
     * @return
     */
    public static int f() {
        return (int) (Math.random() * 5) + 1;
    }

    /**
     * 使用f()函数等概率返回 0 或 1
     *
     * @return
     */
    public static int a() {
        int ans = 0;
        do {
            ans = f();
        } while (ans == 3);
        // f()返回1、2的时候返回0; 4、5的时候返回1
        return ans < 3 ? 0 : 1;
    }

    /**
     * 返回000 ~ 111等概率
     * 做到了 0 ~ 6 等概率返回一个
     *
     * @return
     */
    public static int b(int left, int right) {
        int ans;
        int limit = right - left;
        int site = (int) (Math.log(limit) / Math.log(2));
        do {
            int temp = site;
            ans = 0;
            while (temp >= 0) {
                ans += a() << temp--;
            }
        } while (ans > limit);
        return ans;
    }

    /**
     * 为什么是b()函数加1？
     * b()：笼统一点说等到的是0 ~ 两数差的一个范围值  如：17 ~ 56 那么b()函数得到的是0 ~ ( 56 - 17) = 0 ~ 38范围内的等概率
     * 加 1 是因为要获取的是1 ~ 7所以结果加1  如果是17 ~ 56 那么 c()就是加17
     *
     * @return
     */
    public static int c(int left, int right) {
        return b(left, right) + left;
    }


}