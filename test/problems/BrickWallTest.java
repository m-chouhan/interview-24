package problems;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BrickWallTest {

    BrickWall subject;
    @Before
    public void setUp() throws Exception {
        subject = new BrickWall();
    }

    @Test
    public void leastBricks() {
        List<List<Integer>> list =
                generateArrayListFromString("[[1,2,2,1],[3,1,2],[1,3,2],[2,4],[3,1,2],[1,3,1,1]]");
        assertEquals(2, subject.leastBricks(list));

        list = generateArrayListFromString("[[1]]");
        assertEquals(1, subject.leastBricks(list));

        list = generateArrayListFromString("[[5]]");
        assertEquals(1, subject.leastBricks(list));

        list = generateArrayListFromString("[[5], [3,2]");
        assertEquals(1, subject.leastBricks(list));

        list = generateArrayListFromString("[[1,1],[2],[1,1]]");
        assertEquals(1, subject.leastBricks(list));

        list = generateArrayListFromString("[[1],[1],[1]]");
        assertEquals(3, subject.leastBricks(list));
    }

    public static List<List<Integer>> generateArrayListFromString(String input) {
        List<List<Integer>> outerList = new ArrayList<>();
        // Remove outer brackets
        String trimmedInput = input.substring(1, input.length() - 1);
        // Split by '], [' to get individual inner lists as strings
        String[] innerLists = trimmedInput.split("\\], ?\\[");

        for (String list : innerLists) {
            ArrayList<Integer> innerList = new ArrayList<>();
            // Remove any leading or trailing brackets
            String trimmedList = list.replaceAll("\\[|\\]", "");
            // Split by ',' to get individual numbers
            String[] numbers = trimmedList.split(",");
            for (String number : numbers) {
                try {
                    innerList.add(Integer.parseInt(number.trim()));
                } catch (NumberFormatException e) {
                    // Handle parsing errors, if any
                    System.err.println("Error parsing number: " + number);
                }
            }
            outerList.add(innerList);
        }
        return outerList;
    }
}