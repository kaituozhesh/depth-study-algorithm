package net.ityizhan.algorithm.basic.class4;

/**
 * @ClassName : Code03AddTwoNumbers
 * @Description : 两个链表相加 leetcode: https://leetcode-cn.com/problems/add-two-numbers/
 * @Author : 骚豪 程序驿站: https://www.ityizhan.net
 * @Date: 2021-06-27 11:21
 * @Version: 1.0.0
 */
public class Code03AddTwoNumbers {

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

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(9);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        l2.next.next.next = new ListNode(9);
        addTwoNumbers(l1, l2);
    }

    public static int listCount(ListNode l1) {
        int count = 0;
        while (l1 != null) {
            count++;
            l1 = l1.next;
        }
        return count;
    }


    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        int carry = 0;

        int count1 = listCount(l1);
        int count2 = listCount(l2);
        ListNode cur = count1 >= count2 ? l1 : l2;
        ListNode head = cur;

        ListNode pre = null;
        int sum = 0;
        while (l1 != null && l2 != null) {
            sum = l1.val + l2.val + carry;
            carry = sum / 10;
            cur.val = sum % 10;
            pre = cur;
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        if (l1 != null || l2 != null) {
            l1 = l1 != null ? l1 : l2;
            while (l1 != null) {
                sum = l1.val + carry;
                carry = sum / 10;
                cur.val = sum % 10;
                pre = cur;
                cur = cur.next;
                l1 = l1.next;
            }
        }
        if (carry == 1) {
            pre.next = new ListNode(1);
        }
        return head;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;

        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        while (l1 != null || l2 != null) {
            int num1 = l1 != null ? l1.val : 0;
            int num2 = l2 != null ? l2.val : 0;
            int sum = num1 + num2 + carry;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry == 1) {
            cur.next = new ListNode(carry);
        }
        return pre.next;
    }


}
