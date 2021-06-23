package net.ityizhan.algorithm.basic.class1;

/**
 * @ClassName : SortUtility
 * @Description :
 * @Author : 骚豪 : https://www.ityizhan.net
 * @Date: 2021-06-22 22:22
 * @Version: 1.0.0
 */
public class SortUtility {
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
