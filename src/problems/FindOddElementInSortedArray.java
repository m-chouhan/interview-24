package problems;

/**
 * https://stackoverflow.com/questions/47493317/find-the-element-that-appears-exactly-thrice
 * */
public class FindOddElementInSortedArray {
    static class NumberInfo {
        int count;
        int startIndex;
        int endIndex;
        NumberInfo(int count, int startIndex, int endIndex) {
            this.count = count;
            this.startIndex = startIndex;
            this.endIndex = endIndex;
        }
    }

    int findOdd(int [] array) {
        return findOdd(array, 0, array.length - 1);
    }

    int findOdd(int [] array, int start, int end) {
        if(start > end) return -1;
        if(start == end) {
            NumberInfo info = countOccurence(array, start);
            return info.count % 2 == 0 ? -1 : array[start];
        }

        int mid = (start + end) / 2;
        NumberInfo info = countOccurence(array, mid);
        if(info.count % 2 == 1) return array[mid];
        if((info.startIndex - start) % 2 == 0)
            return findOdd(array, info.endIndex + 1, end);
        return findOdd(array, start, info.startIndex - 1);
    }

    NumberInfo countOccurence(int []array, int start) {
        int rightIndex = start, leftIndex = start;
        while(rightIndex < (array.length - 1) && array[rightIndex + 1] == array[start])
            rightIndex++;
        while(leftIndex > 0 && array[leftIndex - 1] == array[start])
            leftIndex--;
        return new NumberInfo(rightIndex - leftIndex + 1, leftIndex, rightIndex);
    }
}
