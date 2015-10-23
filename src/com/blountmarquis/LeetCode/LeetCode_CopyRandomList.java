package com.blountmarquis.LeetCode;

/**
 * Created by MLBlount on 7/15/2015.
 */
public class LeetCode_CopyRandomList {

    class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    }

    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;

        RandomListNode newHead = new RandomListNode(head.label);
        addNextAndRandom(head, newHead);
        RandomListNode ws = newHead.next;
        head = head.next;
        while (head != null) {
            addNextAndRandom(head, ws);
            ws = ws.next;
            head = head.next;
        }
        return newHead;
    }

    private void addNextAndRandom(RandomListNode oldNode, RandomListNode newNode) {
        newNode.next = oldNode.next == null ? null : new RandomListNode(oldNode.next.label);
        newNode.random = oldNode.random == null ? null : new RandomListNode(oldNode.random.label);
    }
}
