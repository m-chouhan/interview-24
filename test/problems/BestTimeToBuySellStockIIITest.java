package problems;

import org.junit.Test;

import javax.security.auth.Subject;

import java.util.Arrays;

import static org.junit.Assert.*;

public class BestTimeToBuySellStockIIITest {

    BestTimeToBuySellStockIII subject = new BestTimeToBuySellStockIII();

    @Test
    public void maxProfit() {
        int ans1 = subject.maxProfit(new int[]{1,2,3,4,5,6});
        assertEquals(5, ans1);
        int ans2 = subject.maxProfit(new int[]{1,1,1,1,1});
        assertEquals(0, ans2);
        int ans3 = subject.maxProfit(new int[]{1,2,3,1,2,3});
        assertEquals(4, ans3);
    }
}