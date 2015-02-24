
/* Insertion sort 
 * 
 * Worst case performance is O(n^2) comparisons and swaps
 * Best case performance is O(n) comparisons, O(1) swaps
 * Average case performance is O(n^2) comparisons and swaps
 * Worst case space complexity is O(n) total, O(1) auxiliary
 * 
 * */

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args)  {
        
        int[] array = RandomList.generate();
        System.out.println("Generated array: " + Arrays.toString(array));
        sort(array);    
        System.out.println("Sorted array: " + Arrays.toString(array));

    }

    public static void sort(int[] array) {
        
        for (int i = 1; i < array.length; i++)
            for (int j = 0; j < i; j++)
                if (array[i] < array[j]) {
                    int temp = array[i];
                    for (int k = i-1; k >= j; k--)
                        array[k+1] = array[k];
                    array[j] = temp;
                    break;
                }

    }

}
