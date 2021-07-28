package net.ityizhan.algorithm.easy;

/**
 * @ClassName C0026_removeDuplicates
 * @Description 删除有序数组中的重复项
 * @Author 骚豪 程序驿站: https://www.ityizhan.net
 * @Date 2021/7/28 14:24
 * @Version V1.0.0
 **/
public class C0026_removeDuplicates {
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int index = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                continue;
            } else {
                nums[index++] = nums[i];
            }
        }
        return index;
    }


}