package net.ityizhan.algorithm.basic.class1;

/**
 * @ClassName : Code05InsertionSort
 * @Description : 插入排序：默认认为[0 ~ end - 1)为有序的，每轮用下标为end的元素向前比较，前面的元素大就后移。直到前一个元素<=当前进行的元素就停止。end++直到数组有序
 * @Author : 骚豪 : https://www.ityizhan.net
 * @Date: 2021-06-22 22:35
 * @Version: 1.0.0
 */
public class Code05InsertionSort {

    public static void insertSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int n = arr.length;
        for (int end = 1; end < n; end++) {
            int curNumIndex = end;
            while (curNumIndex - 1 >= 0 && arr[curNumIndex - 1] > arr[curNumIndex]) {
                SortUtility.swap(arr, curNumIndex - 1, curNumIndex);
                curNumIndex--;
            }
        }
    }

    public static void insertSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int n = arr.length;
        for (int end = 1; end < n; end++) {
            for (int pre = end - 1; pre >= 0 && arr[pre] > arr[pre + 1]; pre--) {
                SortUtility.swap(arr, pre, pre + 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {7, 234, 6, 123, 44, 1, 3, 2};
        SortUtility.printArray(arr);
        insertSort2(arr);
        SortUtility.printArray(arr);
    }
}
