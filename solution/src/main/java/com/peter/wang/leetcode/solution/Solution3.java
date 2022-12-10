package com.peter.wang.leetcode.solution;

/**
 * 题目3：无重复字符的最长子串
 *
 * @author peter_wang
 * @date 2022/11/30
 */
public class Solution3 {

    /**
     * 执行用时：8 ms, 在所有 Java 提交中击败了22.03%的用户
     * 内存消耗：41.9 MB, 在所有 Java 提交中击败了16.68%的用户
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int maxLength = 1;
        if (s.length() > 1) {
            String cacheStr = s.substring(0, 1);
            for (int i = 1; i < s.length(); i++) {
                String currentChar = s.substring(i, i + 1);
                int existIndex = cacheStr.indexOf(currentChar);
                if (existIndex >= 0) {//查找到第i位的字符存在
                    if (cacheStr.length() > maxLength) {
                        maxLength = cacheStr.length();
                    }
                    cacheStr = cacheStr + currentChar;
                    cacheStr = cacheStr.substring(existIndex + 1, cacheStr.length());
                } else {
                    cacheStr = cacheStr + currentChar;
                    if (cacheStr.length() > maxLength) {
                        maxLength = cacheStr.length();
                    }
                }
            }
        }
        return maxLength;
    }

    /**
     * 执行用时：7 ms, 在所有 Java 提交中击败了26.14%的用户
     * 内存消耗：41.8 MB, 在所有 Java 提交中击败了26.29%的用户
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int maxLength = 1;
        if (s.length() > 1) {
            StringBuilder cacheStr = new StringBuilder(s.substring(0, 1));
            for (int i = 1; i < s.length(); i++) {
                String currentChar = s.substring(i, i + 1);
                int existIndex = cacheStr.indexOf(currentChar);
                if (existIndex >= 0) {//查找到第i位的字符存在
                    if (cacheStr.length() > maxLength) {
                        maxLength = cacheStr.length();
                    }
                    cacheStr.append(currentChar);
                    cacheStr = new StringBuilder(cacheStr.substring(existIndex + 1, cacheStr.length()));
                } else {
                    cacheStr.append(currentChar);
                    if (cacheStr.length() > maxLength) {
                        maxLength = cacheStr.length();
                    }
                }
            }
        }
        return maxLength;
    }

    private static void test() {
        String demo = "abcabcbb";
        System.out.println(lengthOfLongestSubstring2(demo));
    }

    public static void main(String[] args) {
        test();
    }
}
