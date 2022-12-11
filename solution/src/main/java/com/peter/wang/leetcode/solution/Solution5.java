package com.peter.wang.leetcode.solution;

/**
 * 题目5：长回文子串
 * 题目链接：https://leetcode.cn/problems/longest-palindromic-substring/
 *
 * @author peter_wang
 * @date 2022/12/7
 */
public class Solution5 {
    /**
     * 答案提交时间复杂度太大，通过失败，遍历从头开始，截取前面元素i到s.length()开始匹配，匹配不通过则不断缩小范围直到找到
     *
     * @param s 查找的原始字符串
     * @return 最长的回文子串
     */
    public static String longestPalindrome(String s) {
        String maxStr = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length(); j > i; j--) {
                String checkStr = s.substring(i, j);
                if (check2(checkStr) && maxStr.length() < checkStr.length()) {
                    maxStr = checkStr;
                }
            }
        }
        return maxStr;
    }


    /**
     * 遍历各个字符，每个字符查找相同字符，判断两个相同字符间是否是回文子串
     * 执行用时：454 ms, 在所有 Java 提交中击败了5.62%的用户
     * 内存消耗：42.1 MB, 在所有 Java 提交中击败了46.17%的用户
     *
     * @param s 查找的原始字符串
     * @return 最长的回文子串
     */
    public static String longestPalindrome1(String s) {
        String maxStr = "";
        int length = s.length();
        for (int i = 0; i < length; i++) {
            String checkChar = s.substring(0, 1);
            int lastSameIndex = s.lastIndexOf(checkChar);
            boolean found = false;
            String temporaryStr = s;
            while (lastSameIndex != -1 && !found) {
                String checkStr = temporaryStr.substring(0, lastSameIndex + 1);
                if (check2(checkStr)) {
                    found = true;
                    if (maxStr.length() < checkStr.length()) {
                        maxStr = checkStr;
                    }
                } else {//不是答案则继续缩短字符串遍历
                    temporaryStr = temporaryStr.substring(0, lastSameIndex);
                    lastSameIndex = temporaryStr.lastIndexOf(checkChar);
                }
            }
            if (s.length() > 0) {
                s = s.substring(1);
            }
        }
        return maxStr;
    }

    /**
     * 匹配反转字符串以后是否相等，利用StringBuffer，速度比check1更快
     *
     * @param checkStr 比对的字符串
     * @return 是否是回文子串
     */
    private static boolean check2(String checkStr) {
        String reverseStr = new StringBuffer(checkStr).reverse().toString();
        return checkStr.equals(reverseStr);
    }

    /**
     * 匹配反转字符串以后是否相等
     *
     * @param checkStr 比对的字符串
     * @return 是否是回文子串
     */
    private static boolean check1(String checkStr) {
        char[] checkArray = checkStr.toCharArray();
        for (int i = 0; i < checkArray.length / 2; i++) {
            if (checkArray[i] != checkArray[checkArray.length - i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static void test() {
        String testStr = "jglknendplocymmvwtoxvebkekzfdhykknufqdkntnqvgfbahsljkobhbxkvyictzkqjqydczuxjkgecdyhixdttxfqmgksrkyvopwprsgoszftuhawflzjyuyrujrxluhzjvbflxgcovilthvuihzttzithnsqbdxtafxrfrblulsakrahulwthhbjcslceewxfxtavljpimaqqlcbrdgtgjryjytgxljxtravwdlnrrauxplempnbfeusgtqzjtzshwieutxdytlrrqvyemlyzolhbkzhyfyttevqnfvmpqjngcnazmaagwihxrhmcibyfkccyrqwnzlzqeuenhwlzhbxqxerfifzncimwqsfatudjihtumrtjtggzleovihifxufvwqeimbxvzlxwcsknksogsbwwdlwulnetdysvsfkonggeedtshxqkgbhoscjgpiel";
        System.out.println(longestPalindrome1(testStr));
    }

    public static void main(String[] args) {
        test();
    }
}
