package net.ityizhan.algorithm.basic.class4;

import java.util.List;

/**
 * @ClassName Code2ReverseNodesInKGroup
 * @Description
 * @Author 骚豪 程序驿站: https://www.ityizhan.net
 * @Date 2021/6/28 10:15
 * @Version V1.0.0
 **/
public class Code2ReverseNodesInKGroup {
    public class ListNode {
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

    public ListNode getNodeByK(ListNode head, int k) {
        while (--k != 0 && head != null) {
            head = head.next;
        }
        return head;
    }

    public static void reverse(ListNode start, ListNode end) {
        end = end.next;
        ListNode pre = null;
        ListNode cur = start;
        ListNode next;
        while (cur != end) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        start.next = end;
    }


    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode start = head;
        ListNode end = getNodeByK(start, k);
        if (end == null) {
            return head;
        }
        head = end;
        reverse(start, end);
        ListNode lastEnd = start;
        while (lastEnd.next != null) {
            start = lastEnd.next;
            end = getNodeByK(start, k);
            if (end == null) {
                return head;
            }
            reverse(start, end);
            lastEnd.next = end;
            lastEnd = start;
        }
        return head;
    }


}