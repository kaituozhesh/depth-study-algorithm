package net.ityizhan.algorithm.basic.utility;

import java.lang.reflect.Method;

/**
 * @ClassName SortTestHelper
 * @Description 排序算法检验工具
 * @Author 骚豪: https://www.ityizhan.net
 * @Date 2021/6/23 14:15
 * @Version V1.0.0
 **/
public class SortTestHelper {

    /**
     * 返回一个随机长度随机值的数组
     * 长度为：[0, maxLen - 1]
     * 每个值：[0, maxValue - 1]
     *
     * @param maxLen
     * @param maxValue
     * @return
     */
    public static int[] lenRandomValueRandom(int maxLen, int maxValue) {
        int len = (int) (Math.random() * maxLen);
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            ans[i] = (int) (Math.random() * maxValue);
        }
        return ans;
    }

    /**
     * 返回一个固定长度 元素值范围：[rangeL, rangeR]
     *
     * @param n
     * @param rangeL
     * @param rangeR
     * @return
     */
    public static int[] fixedLenRandomArray(int n, int rangeL, int rangeR) {
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = (int) (Math.random() * (rangeR - rangeL + 1) + rangeL);
        }
        return ans;
    }

    /**
     * 返回数组是否有序
     *
     * @param arr
     * @return
     */
    public static boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 打印arr数组的所有内容
     */
    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    /**
     * copy数组
     *
     * @param arr
     * @return
     */
    public static int[] copyArray(int[] arr) {
        int[] ans = new int[arr.length];
        System.arraycopy(arr, 0, ans, 0, arr.length);
        return ans;
    }

    /**
     * 对指定数组使用clazz类中的methodName方法进行排序测试
     *
     * @param clazz
     * @param methodName
     * @param arr
     */
    public static void testSort(Class<?> clazz, String methodName, int[] arr) {
        try {
            Method sortMethod = clazz.getMethod(methodName, int[].class);
            // 备份一下原数组，排序出错时打印
            int[] temp = copyArray(arr);

            long startTime = System.currentTimeMillis();
            sortMethod.invoke(null, arr);
            long endTime = System.currentTimeMillis();

            if (!isSorted(arr)) {
                System.out.println("排序出错: ");
                System.out.print("原数组: ");
                printArray(temp);
                System.out.print("排序后数组: ");
                printArray(arr);
            }

            System.out.println(clazz.getSimpleName() + " : " + (endTime - startTime) + "ms");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int[] strategy(boolean isRandom, int n, int rangeL, int rangeR) {
        return isRandom ? lenRandomValueRandom(n, rangeR) : fixedLenRandomArray(n, rangeL, rangeR);
    }

    /**
     * 测试n次排序 打印平均时间
     * CPU充分预热后 平均时间会小于单次执行时间
     *
     * @param clazz
     * @param methodName
     * @param isRandom
     * @param n
     * @param rangeL
     * @param rangeR
     */
    public static void testSort(Class<?> clazz, String methodName, int timesTest, boolean isRandom, int n, int rangeL, int rangeR) {
        try {
            Method sortMethod = clazz.getMethod(methodName, int[].class);
            long totalTime = 0;
            for (int i = 0; i < timesTest; i++) {
                int[] arr = strategy(isRandom, n, rangeL, rangeR);
                int[] temp = copyArray(arr);
                long startTime = System.currentTimeMillis();
                sortMethod.invoke(null, arr);
                totalTime += System.currentTimeMillis() - startTime;

                if (!isSorted(arr)) {
                    System.out.println("排序出错: ");
                    System.out.print("原数组: ");
                    printArray(temp);
                    System.out.print("排序后数组: ");
                    printArray(arr);
                    return;
                }
            }
            System.out.println(totalTime);
            System.out.println(clazz.getSimpleName() + " : " + (totalTime / timesTest) + "ms");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}