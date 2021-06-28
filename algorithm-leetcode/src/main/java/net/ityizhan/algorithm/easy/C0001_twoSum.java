package net.ityizhan.algorithm.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName C0001_twoSum
 * @Description 两数之和：https://leetcode-cn.com/problems/two-sum/
 * <p>
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 * @Author 骚豪 程序驿站: https://www.ityizhan.net
 * @Date 2021/6/28 17:07
 * @Version V1.0.0
 **/
public class C0001_twoSum {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum(nums, 9)));
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>(nums.length);

        for (int i = 0; i < nums.length; i++) {
            if (numMap.containsKey(nums[i])) {
                return new int[]{i, numMap.get(nums[i])};
            }
            numMap.put(target - nums[i], i);

        }
        return null;
    }
}