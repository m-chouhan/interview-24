package problems;

import datastructures.LinkNode;

public class AddTwoNumbersInLinkList {
    /** Definition for singly-linked list. */

    public LinkNode<Integer> addTwoNumbers(LinkNode<Integer> l1, LinkNode<Integer> l2) {

        int carryOver = 0;
        LinkNode<Integer> head = null;

        while(l1 != null || l2 != null || carryOver != 0) {

            int lValue = (l1 != null) ? l1.val : 0;
            int rValue = (l2 != null) ? l2.val : 0;

            // compute value based on numbers and result of previous computation.
            int computedValue = lValue + rValue + carryOver;
            head = new LinkNode<Integer>(computedValue%10, head);

            carryOver = computedValue/10;

            // move pointers till the hit the end.
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }

        return reverseLinklist(head);
    }

    LinkNode reverseLinklist(LinkNode head) {
        LinkNode previous = null, current = head, next = head.next;
        while (next != null) {
            current.next = previous;

            // update reference and move on with life!
            previous = current;
            current = next;
            next = next.next;
        }
        current.next = previous;

        return current;
    }
}
