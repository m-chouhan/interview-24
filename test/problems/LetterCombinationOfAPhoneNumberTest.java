package problems;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class LetterCombinationOfAPhoneNumberTest {

    LetterCombinationOfAPhoneNumber testSubject = new LetterCombinationOfAPhoneNumber();

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void appendCharToStrings() {
        List<String> inputList = Arrays.asList("Mahendra", "Chouhan");
        List<String> outputList = testSubject.appendCharToStrings('a', inputList);
        List<String> expectedOutputList = Arrays.asList("Mahendraa", "Chouhana");
        assertEquals("Function should append character to list items", expectedOutputList, outputList);

        // empty list test
        outputList = testSubject.appendCharToStrings('b', new ArrayList<>());
        expectedOutputList = Arrays.asList("b");
        assertEquals("Appending char to empty list should create new list item", expectedOutputList, outputList);
    }

    @Test
    public void letterCombinations() {
        List<String> output1 = testSubject.letterCombinations("2");
        List<String> expectedOutputList1 = Arrays.asList("a", "b", "c");
        assertEquals("2 -> a,b,c", expectedOutputList1, output1);

        List<String> output2 = testSubject.letterCombinations("9");
        List<String> expectedOutputList2 = Arrays.asList("w", "x", "y", "z");
        assertEquals("9 -> w,x,y,z", expectedOutputList2, output2);

        List<String> output3 = testSubject.letterCombinations("92");
        List<String> expectedOutputList3 = Arrays.asList("wa", "xa", "ya", "za",
                                                         "wb", "xb", "yb", "zb",
                                                         "wc", "xc", "yc", "zc");
        assertEquals("92 -> w,x,y,z", expectedOutputList3, output3);
    }
}