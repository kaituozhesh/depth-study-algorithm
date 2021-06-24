package net.ityizhan.algorithm.basic.class3;

/**
 * @ClassName Code01BSExist
 * @Description 二分查找：每次选择一个中位数 判断：相等直接返回true，小于（到右半部分查找）：left = mid + 1 大于（到左半部分查找）：right = mid - 1
 * @Author 骚豪 程序驿站: https://www.ityizhan.net
 * @Date 2021/6/24 9:15
 * @Version V1.0.0
 **/
public class Code01BSExist {

    public static boolean exist(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == num) {
                return true;
            } else if (arr[mid] < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

}