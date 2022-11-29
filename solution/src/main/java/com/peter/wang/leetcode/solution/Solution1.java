package com.peter.wang.leetcode.solution;

public class Solution1 {
    /**
     * 题目链接：https://leetcode.cn/problems/two-sum/
     * 执行用时：55 ms, 在所有 Java 提交中击败了26.13%的用户
     * 内存消耗：41.9 MB, 在所有 Java 提交中击败了14.90%的用户
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum1(int[] nums, int target) {
        int[] result = new int[2];
        OUT:
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    break OUT;
                }
            }
        }

        return result;
    }

    private static void test1() {
        int[] nums = {1, 2, 3, 4};
        int target = 6;
        int[] result = twoSum1(nums, target);
        System.out.println(result[0] + "," + result[1]);
    }

    public static void main(String[] args) {
        test1();
    }
}