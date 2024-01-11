package problems;

import org.junit.Test;

import static org.junit.Assert.*;
import java.util.*;

public class BestTimeToBuySellStockTest {

    BestTimeToBuySellStock subject = new BestTimeToBuySellStock();
    @Test
    public void maxProfit() {
        int answer1 = subject.maxProfit(new int[]{1});
        assertEquals(0, answer1);

        int answer2 = subject.maxProfit(new int[]{1, 2, 3});
        assertEquals(2, answer2);

        int answer3 = subject.maxProfit(new int[]{3, 2, 1});
        assertEquals(0, answer3);

        int answer4 = subject.maxProfit(new int[]{1, 2, 1, 2, 10, 11, 12});
        assertEquals(11, answer4);
    }

    @Test
    public void maxProfitII() {
        int answer1 = subject.maxProfitII(new int[]{1});
        assertEquals(0, answer1);

        int answer2 = subject.maxProfitII(new int[]{1, 2, 3});
        assertEquals(2, answer2);

        int answer3 = subject.maxProfitII(new int[]{3, 2, 1});
        assertEquals(0, answer3);

        int answer4 = subject.maxProfitII(new int[]{1, 2, 1, 2, 10, 11, 12});
        assertEquals(11, answer4);
    }

}