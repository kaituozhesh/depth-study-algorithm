package net.ityizhan.algorithm.basic.class5;

import java.util.HashSet;

/**
 * @ClassName Code01BitMap
 * @Description 位图
 * @Author 骚豪 程序驿站: https://www.ityizhan.net
 * @Date 2021/6/29 15:38
 * @Version V1.0.0
 **/
public class Code01BitMap {

    /**
     * 使用位图来实现set的add和删除过程
     */
    public static class BitMap {
        private long[] bits;

        public BitMap(int max) {
            bits = new long[(max + 64) >> 6];
        }

        public void add(int num) {
            bits[num >> 6] |= 1L << (num & 63);
        }

        public void delete(int num) {
            bits[num >> 6] &= ~(1L << (num & 63));
        }

        public boolean contains(int num) {
            return (bits[num >> 6] & (1L << (num & 63))) != 0;
        }

    }


    public static void main(String[] args) {
        System.out.println("测试开始");

        int max = 10000;
        BitMap bitMap = new BitMap(max);
        HashSet<Integer> set = new HashSet<>();
        int testTime = 1000000;

        for (int i = 0; i < testTime; i++) {
            int num = (int) (Math.random() * (max + 1));
            double decide = Math.random();
            if (decide < 0.333) {
                bitMap.add(num);
                set.add(num);
            } else if (decide < 0.666) {
                bitMap.delete(num);
                set.remove(num);
            } else {
                if (bitMap.contains(num) != set.contains(num)) {
                    System.out.println("Oops!");
                    break;
                }
            }
        }

        for (int i = 0; i < max; i++) {
            if (bitMap.contains(i) != set.contains(i)) {
                System.out.println("Oops");
            }
        }
        System.out.println("测试结束");


    }

}