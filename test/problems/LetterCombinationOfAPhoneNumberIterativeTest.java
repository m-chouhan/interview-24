package problems;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class LetterCombinationOfAPhoneNumberIterativeTest {

    LetterCombinationOfAPhoneNumberIterative testSubject = new LetterCombinationOfAPhoneNumberIterative();
    @Test
    public void letterCombinations() {
            List<String> output1 = testSubject.letterCombinations("2");
            List<String> expectedOutputList1 = Arrays.asList("a", "b", "c");
            assertEquals("2 -> a,b,c", expectedOutputList1, output1);

            List<String> output2 = testSubject.letterCombinations("9");
            List<String> expectedOutputList2 = Arrays.asList("w", "x", "y", "z");
            assertEquals("9 -> w,x,y,z", expectedOutputList2, output2);

            List<String> output3 = testSubject.letterCombinations("92");
            List<String> expectedOutputList3 = Arrays.asList("wa", "wb", "wc",
                    "xa", "xb", "xc",
                    "ya", "yb", "yc",
                    "za", "zb", "zc");
            assertEquals("92 -> w,x,y,z", expectedOutputList3, output3);
        }
}