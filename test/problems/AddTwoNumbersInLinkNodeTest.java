package problems;

import datastructures.LinkList;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

/**
 * https://leetcode.com/problems/add-two-numbers
 * */
public class AddTwoNumbersInLinkListTest {

    AddTwoNumbersInLinkList subject = new AddTwoNumbersInLinkList();

    LinkList buildLinkList(List<Integer> list) {
        LinkList head = null;
        for (Integer in : list) {
            head = new LinkList(in, head);
        }
        return head;
    }

    LinkList buildLinkList(Integer number) {
        LinkList head = new LinkList(number % 10);
        LinkList lastNode = head;
        number = number / 10;

        while(number > 0) {
            int lastDigit = number % 10;
            LinkList currentNode = new LinkList(lastDigit);
            lastNode.next = currentNode;
            lastNode = currentNode;
            number = number/10;
        }
        return head;
    }

    int convertLinklistToNumber(LinkList head) {
        int finalValue = 0, i = 0;

        while(head != null) {
            finalValue = (int) (head.val * Math.pow(10, i) + finalValue);
            head = head.next; ++i;
        }
        return finalValue;
    }

    @Test
    public void addTwoNumbers() {
        LinkList output1 = subject.addTwoNumbers(buildLinkList(99), buildLinkList(1));
        int sum1 = convertLinklistToNumber(output1);
        assertEquals(100, sum1);

        LinkList output2 = subject.addTwoNumbers(buildLinkList(111), buildLinkList(1));
        int sum2 = convertLinklistToNumber(output2);
        assertEquals(112, sum2);
    }

    @Test
    public void reverseLinklist() {
        LinkList output = subject.reverseLinklist(buildLinkList(1234));
        assertEquals(4321, convertLinklistToNumber(output));

        LinkList output1 = subject.reverseLinklist(buildLinkList(1));
        assertEquals(1, convertLinklistToNumber(output1));
    }
}