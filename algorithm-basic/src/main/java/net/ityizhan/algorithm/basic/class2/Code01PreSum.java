package net.ityizhan.algorithm.basic.class2;

/**
 * @ClassName Code01PreSum
 * @Description 前缀和：频繁需要计算数组下标L ~ R的累加和可以采用方式
 *                     额外开辟一块数组空间，对应下标记录 0 ~ 对应下标的累加和。
 *                     获取累加和：preSum[right] - preSum[left - 1] 如果 left = 0 直接返回 preSum[right]
 *                     如: 原数组：[1, 3, 5, 7,   9]
 *                         前缀和：[1, 4, 9, 16, 25]
 *                     获取：left = 0, right = 3  结果：preSum[right] = 16
 *                     获取：left = 1, right = 3  结果：preSum[right] - preSum[left - 1] = 15
 * @Author 程序驿站: https://www.ityizhan.net
 * @Date 2021/6/23 10:35
 * @Version V1.0.0
 **/
public class Code01PreSum {

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 2, 3, 66, 12};
        RangeSum rangeSum = new RangeSum(arr);
        System.out.println(rangeSum.rangeSum(2, 5));
    }


    public static class RangeSum {
        private int[] preSum;

        RangeSum(int[] array) {
            int n = array.length;
            preSum = new int[n];
            preSum[0] = array[0];
            for (int i = 1; i < n; i++) {
                preSum[i] = preSum[i - 1] + array[i];
            }
        }

        public int rangeSum(int left, int right) {
            if (left < 0 || right > preSum.length - 1) {
                throw new IllegalArgumentException("Illegal Index.");
            }
            return left == 0 ? preSum[right] : preSum[right] - preSum[left - 1];
        }
    }


}