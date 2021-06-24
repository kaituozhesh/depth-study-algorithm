package net.ityizhan.algorithm.basic.utility;

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

    public static void bitOpSwap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
