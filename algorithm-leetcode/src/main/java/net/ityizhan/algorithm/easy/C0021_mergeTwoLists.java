package net.ityizhan.algorithm.easy;

/**
 * @ClassName C0021_mergeTwoLists
 * @Description 合并两个有序链表
 * @Author 骚豪 程序驿站: https://www.ityizhan.net
 * @Date 2021/7/28 14:35
 * @Version V1.0.0
 **/
public class C0021_mergeTwoLists {
    class ListNode {
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

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        // 找出较小的头节点，相同则使用l1作为头结点
        ListNode head = l1.val <= l2.val ? l1 : l2;
        // 最小节点所在链表的后一个节点
        ListNode cur1 = head.next;
        // 如果l1是头节点则返回l2
        ListNode cur2 = l1 == head ? l2 : l1;
        ListNode pre = head;
        while (cur1 != null && cur2 != null) {
            if (cur1.val <= cur2.val) {
                pre.next = cur1;
                cur1 = cur1.next;
            } else {
                pre.next = cur2;
                cur2 = cur2.next;
            }
            pre = pre.next;
        }

        pre.next = cur1 != null ? cur1 : cur2;

        return head;
    }
}