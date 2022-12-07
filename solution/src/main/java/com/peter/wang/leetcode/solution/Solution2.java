package com.peter.wang.leetcode.solution;

/**
 * 题目2：两数相加
 * 题目链接：https://leetcode.cn/problems/add-two-numbers/
 *
 * @author peter_wang
 * @date 2022/12/7
 */
public class Solution2 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：41.8 MB, 在所有 Java 提交中击败了19.56%的用户
     *
     * @param l1 列表1
     * @param l2 列表2
     * @return 两数相加结果
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean isExit = false;//是否结束运算退出循环
        boolean isCarry = false;//是否需进位
        ListNode result = new ListNode();
        ListNode resultLast = result;
        while (!isExit) {
            int sum = 0;
            if (l1 != null) {
                sum += l1.val;
            }
            if (l2 != null) {
                sum += l2.val;
            }
            if (isCarry) {
                sum++;
            }

            if (sum >= 10) {
                resultLast.val = sum - 10;
                isCarry = true;
            } else {
                resultLast.val = sum;
                isCarry = false;
            }

            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
            if (l1 == null && l2 == null && !isCarry) {
                isExit = true;
            } else {
                resultLast.next = new ListNode();
                resultLast = resultLast.next;
            }
        }
        return result;
    }

    private static void test() {
        ListNode l1 = new ListNode();
        l1.val = 2;
        ListNode l1_1 = new ListNode();
        l1_1.val = 4;
        l1.next = l1_1;
        ListNode l1_2 = new ListNode();
        l1_2.val = 3;
        l1_1.next = l1_2;

        ListNode l2 = new ListNode();
        l2.val = 2;
        ListNode l2_1 = new ListNode();
        l2_1.val = 4;
        l2.next = l2_1;
        ListNode result = addTwoNumbers(l1, l2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public static void main(String[] args) {
        test();
    }
}
