package problems;

import datastructures.LinkNode;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

/**
 * <a href="https://leetcode.com/problems/add-two-numbers">...</a>
 * */
public class AddTwoNumbersInLinkNodeTest {

    AddTwoNumbersInLinkList subject = new AddTwoNumbersInLinkList();

    LinkNode buildLinkList(List<Integer> list) {
        LinkNode head = null;
        for (Integer in : list) {
            head = new LinkNode(in, head);
        }
        return head;
    }

    LinkNode buildLinkList(Integer number) {
        LinkNode head = new LinkNode<Integer>(number % 10);
        LinkNode lastNode = head;
        number = number / 10;

        while(number > 0) {
            int lastDigit = number % 10;
            LinkNode currentNode = new LinkNode(lastDigit);
            lastNode.next = currentNode;
            lastNode = currentNode;
            number = number/10;
        }
        return head;
    }

    int convertLinklistToNumber(LinkNode<Integer> head) {
        int finalValue = 0, i = 0;

        while(head != null) {
            finalValue = (int) (head.val * Math.pow(10, i) + finalValue);
            head = head.next; ++i;
        }
        return finalValue;
    }

    @Test
    public void addTwoNumbers() {
        LinkNode output1 = subject.addTwoNumbers(buildLinkList(99), buildLinkList(1));
        int sum1 = convertLinklistToNumber(output1);
        assertEquals(100, sum1);

        LinkNode output2 = subject.addTwoNumbers(buildLinkList(111), buildLinkList(1));
        int sum2 = convertLinklistToNumber(output2);
        assertEquals(112, sum2);
    }

    @Test
    public void reverseLinklist() {
        LinkNode output = subject.reverseLinklist(buildLinkList(1234));
        assertEquals(4321, convertLinklistToNumber(output));

        LinkNode output1 = subject.reverseLinklist(buildLinkList(1));
        assertEquals(1, convertLinklistToNumber(output1));
    }
}