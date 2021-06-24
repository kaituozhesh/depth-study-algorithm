package net.ityizhan.algorithm.basic.class1;

import net.ityizhan.algorithm.basic.utility.SortTestUtility;
import net.ityizhan.algorithm.basic.utility.SortUtility;

/**
 * @ClassName : Code04BubbleSort
 * @Description : 冒泡排序：从下标0开始相邻两个元素比较，较大的元素后移，这样每一轮下来都会从0 ~ end（未排序数组长度）得到一个最大值放到end位置，end--
 * @Author : 骚豪 : https://www.ityizhan.net
 * @Date: 2021-06-22 22:22
 * @Version: 1.0.0
 */
public class Code04BubbleSort {


    private static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int n = arr.length;
        for (int end = n - 1; end >= 0; end--) {
            for (int second = 1; second <= end; second++) {
                if (arr[second - 1] > arr[second]) {
                    SortUtility.swap(arr, second - 1, second);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = SortTestUtility.fixedLenRandomArray(20000, 0, 100000);
        SortTestUtility.testSort(Code04BubbleSort.class, "bubbleSort", arr);
    }
}
