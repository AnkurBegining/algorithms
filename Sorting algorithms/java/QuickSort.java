
/* Randomized Quicksort 
 * 
 * Worst case performance is O(nlog(n))
 * Best case performance is O(nlog(n))
 * Average case performance is O(nlog(n))
 * 
 * */

import java.util.Arrays;

public class QuickSort {
    
    public static void main(String[] args) {
        
        int[] array = RandomList.generate();
        System.out.println("Generated array: " + Arrays.toString(array));
        sort(array, 0, array.length-1);
        System.out.println("Sorted array: " + Arrays.toString(array));

    }

    public static void sort(int[] array, int left, int right) {
        
        if (left < right) {

            //pivot is chosen randomly among the elements corresponding the array section we are working on
            int pivot_index = (int)(Math.random()*(right-left+1) + left);

            //swap pivot with leftmost element corresponding to the array section we're working on
            int temp = array[pivot_index];
            array[pivot_index] = array[left];
            array[left] = temp;

            //change the pivot index accordingly
            pivot_index = left;
            
            //i tracks the leftmost element bigger than the pivot 
            int i = left + 1;

            //partitioning
            for (int j = left + 1; j <= right; j++)
                
                if (array[j] < array[pivot_index]) { //swap
                    int temp2 = array[i];
                    array[i] = array[j];
                    array[j] = temp2;
                    i++;
                }


            //final swap of the pivot with the rightmost element in the left partitioned section of the array
            int temp2 = array[pivot_index];
            array[pivot_index] = array[i-1];
            array[i-1] = temp2;

            //Recurse on the left side (without the pivot)
            sort(array, left, i-2);

            //Recurse on the right side
            sort(array, i, right);
        }

    }
}
