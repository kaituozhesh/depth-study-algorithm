package net.ityizhan.algorithm.basic.class4;

/**
 * @ClassName : Code01ReverseList
 * @Description : 反转单向链表
 * @Author : 骚豪 程序驿站: https://www.ityizhan.net
 * @Date: 2021-06-26 14:52
 * @Version: 1.0.0
 */
public class Code01ReverseList {

    /**
     * 单向链表
     */
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public Node reverseList(Node head) {

        Node pre = null;
        Node next;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }

        return pre;
    }

    /**
     * 双向链表
     */
    public static class DoubleNode {
        private int value;
        private DoubleNode pre;
        private DoubleNode next;

        public DoubleNode(int value) {
            this.value = value;
        }
    }

    /**
     * 反转双向链表
     *
     * @param head
     * @return
     */
    public DoubleNode reverseDoubleList(DoubleNode head) {

        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.pre = next;

            pre = head;
            head = next;
        }
        return pre;
    }

}
