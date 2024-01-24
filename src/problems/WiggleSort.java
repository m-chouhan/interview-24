package problems;

/**
 * Wiggle Sort problem
 * https://leetcode.com/problems/wiggle-sort/
 * */
public class WiggleSort {
    public int[] wiggleSort(int[] array) {
        if(array.length == 2 && array[0] >= array[1])
            swap(array, 0, 1);
        for(int i = 0; (i + 2) < array.length; ++i)
            if(!zigzag(array, i))
                rearrange(array, i);
        return array;
    }

    boolean zigzag(int [] array, int index) {
        return (index % 2 == 0)
                ? array[index] <= array[index+1] && array[index+1] >= array[index+2]
                : array[index] >= array[index+1] && array[index+1] <= array[index+2];
    }

    void swap(int [] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    void rearrange(int []array, int index) {
        int small = Math.min(Math.min(array[index], array[index+1]), array[index+2]);
        int large = Math.max(Math.max(array[index], array[index+1]), array[index+2]);
        int mid = array[index] + array[index+1] + array[index+2] - small - large;

        if(index % 2 == 0) {
            array[index] = small;
            array[index+1] = large;
            array[index+2] = mid;
        } else {
            array[index] = large;
            array[index+1] = small;
            array[index+2] = mid;
        }
    }
}
