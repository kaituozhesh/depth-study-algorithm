package net.ityizhan.algorithm.basic.class3;

import net.ityizhan.algorithm.basic.utility.SortUtility;

/**
 * @ClassName Code04BSAwesome
 * @Description 返回一个局部最小的下标
 * @Author 骚豪 程序驿站: https://www.ityizhan.net
 * @Date 2021/6/24 13:21
 * @Version V1.0.0
 **/
public class Code04BSAwesome {

    public static int onMinIndex(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        } else if (arr.length == 1) {
            return 0;
        } else if (arr.length == 2) {
            return arr[0] < arr[1] ? 0 : 1;
        } else {
            int left = 0;
            int right = arr.length - 1;
            while (left < right - 1) {
                int mid = (right - left) / 2 + left;
                if (arr[mid] < arr[mid - 1] && arr[mid] < arr[mid + 1]) {
                    return mid;
                    // 1 左 > 我  我 > 右
                    // 2 左 < 我  我 < 右
                    // 3 左 < 我  我 > 右
                } else if (arr[mid] > arr[mid - 1]) {
                    right = mid - 1;
                } else { // arr[mid] > arr[mid + 1]
                    left = mid + 1;
                }
            }

            return arr[left] < arr[right] ? left : right;
        }
    }

    /**
     * 生成随机数组，且相邻数不相等
     *
     * @param maxLen
     * @param maxValue
     * @return
     */
    public static int[] randomArray(int maxLen, int maxValue) {
        int len = (int) (Math.random() * maxLen);
        int[] arr = new int[len];
        if (len > 0) {
            arr[0] = (int) (Math.random() * maxValue);
            for (int i = 1; i < len; i++) {
                do {
                    arr[i] = (int) (Math.random() * maxValue);
                } while (arr[i] == arr[i - 1]);
            }
        }
        return arr;
    }

    public static boolean check(int[] arr, int minIndex) {
        if (arr.length == 0) {
            return minIndex == -1;
        }
        int left = minIndex - 1;
        int right = minIndex + 1;
        // 左边是否比minIndex大
        boolean leftBigger = left < 0 || arr[left] > arr[minIndex];
        // 右边是否比minIndex大
        boolean rightBigger = right >= arr.length || arr[right] > arr[minIndex];
        // 左右两边是否都比minIndex大
        return leftBigger && rightBigger;
    }

    public static void main(String[] args) {
        int testTime = 100000;
        int maxLen = 100;
        int maxValue = 200;
        for (int i = 0; i < testTime; i++) {
            int[] arr = randomArray(maxLen, maxValue);
            int ans = onMinIndex(arr);
            if (!check(arr, ans)) {
                SortUtility.printArray(arr);
                System.out.println(ans);
                break;
            }
        }
    }
}