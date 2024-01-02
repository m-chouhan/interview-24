package problems;

import datastructures.LinkList;

public class AddTwoNumbersInLinkList {
    /** Definition for singly-linked list. */

    public LinkList addTwoNumbers(LinkList l1, LinkList l2) {

        int carryOver = 0;
        LinkList head = null;

        while(l1 != null || l2 != null || carryOver != 0) {

            int lValue = (l1 != null) ? l1.val : 0;
            int rValue = (l2 != null) ? l2.val : 0;

            // compute value based on numbers and result of previous computation.
            int computedValue = lValue + rValue + carryOver;
            LinkList newNode = new LinkList(computedValue%10, head);
            head = newNode;

            carryOver = computedValue/10;

            // move pointers till the hit the end.
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }

        return reverseLinklist(head);
    }

    LinkList reverseLinklist(LinkList head) {
        LinkList previous = null, current = head, next = head.next;
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
