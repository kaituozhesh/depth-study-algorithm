package net.ityizhan.algorithm.basic.class3;

/**
 * @ClassName Code02BSNearLeft
 * @Description
 * @Author 骚豪 程序驿站: https://www.ityizhan.net
 * @Date 2021/6/24 10:55
 * @Version V1.0.0
 **/
public class Code02BSNearLeft {

    /**
     * 在arr上找满足>=value的最左下标
     *
     * @param arr
     * @param value
     * @return
     */
    public static int leftNearestIndex(int[] arr, int value) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int left = 0;
        int right = arr.length - 1;
        int ans = -1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (arr[mid] >= value) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }


}