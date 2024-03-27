package problems;

/**
 * Recently asked at Amazon - SDE 3
 * Given a sorted array, find the number of occurences of a given value - log(n)
 * */
public class FindElementCountInSortedArray {

    int findCount(int [] array, int value) {
        if(array.length == 0) return 0;
        int lowerIndex = findLowerBound(array, value); // index of first occurence, -1 otherwise.
        if(lowerIndex == -1) return 0;
        int upperIndex = findUpperBound(array, value); // index of last occurence, -1 othwerwise.
        return upperIndex - lowerIndex + 1;
    }

    int findLowerBound(int [] array, int value) {
        int start = 0, end = array.length - 1;
        while(start < end) {
            int mid = start + (end - start) / 2;
            if(array[mid] == value) end = mid;
            else if(array[mid] < value) start = mid + 1;
            else end = mid - 1;
        }
        return array[start] == value ? start : -1;
    }

    int findUpperBound(int [] array, int value) {
        int start = 0, end = array.length - 1;
        while(start < end) {
            int mid = start + (end - start + 1) / 2;
            if(array[mid] == value) start = mid;
            else if(array[mid] < value) start = mid + 1;
            else end = mid - 1;
        }
        return array[end] == value ? end : -1;
    }
}
