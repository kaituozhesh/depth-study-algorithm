package net.ityizhan.algorithm.basic.class1;

import net.ityizhan.algorithm.basic.utility.SortTestHelper;
import net.ityizhan.algorithm.basic.utility.SortUtility;

/**
 * @ClassName : Code03_SelectionSort
 * @Description : 选择排序：每一轮从i ~ n -1中找出最小的元素跟i位置的元素进行交换，之后i++，直到数组有序
 * @Author : 骚豪 : https://www.ityizhan.net
 * @Date: 2021-06-22 22:10
 * @Version: 1.0.0
 */
public class Code03SelectionSort {

    public static void selectSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int n = arr.length;
        // i ~ n - 1 范围内找出最小的数根i做交换
        for (int i = 0; i < n; i++) {
            int minValueIndex = i;
            for (int j = i + 1; j < n; j++) {
                minValueIndex = arr[j] < arr[minValueIndex] ? j : minValueIndex;
            }
            SortUtility.swap(arr, i, minValueIndex);
        }
    }

    public static void main(String[] args) {
        int[] arr = SortTestHelper.fixedLenRandomArray(20000, 0, 100000);
        SortTestHelper.testSort(Code03SelectionSort.class, "selectSort", arr);
    }

}
