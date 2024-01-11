package problems;

import org.junit.Test;

import static org.junit.Assert.*;

public class BestTimeToBuySellStockIITest {

    BestTimeToBuySellStockII subject = new BestTimeToBuySellStockII();

    @Test
    public void maxProfit() {
        int answer1 = subject.maxProfit(new int[]{1});
        assertEquals(0, answer1);

        int answer2 = subject.maxProfit(new int[]{1, 2, 3});
        assertEquals(2, answer2);

        int answer3 = subject.maxProfit(new int[]{3, 2, 1});
        assertEquals(0, answer3);

        int answer4 = subject.maxProfit(new int[]{1, 2, 1, 2, 10, 11, 12});
        assertEquals(12, answer4);
    }
}