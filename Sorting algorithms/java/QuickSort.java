
/* Randomized Quicksort 
 * 
 * Worst case performance if randomized is O(nlogn)
 * Worst case performance if not randomized is O(n^2)
 * Best case performance is O(nlog(n)) simple partition, O(n) (three-way partition and equal keys)
 * Average case performance is O(nlog(n))
 * Worst case space complexity O(n) auxiliary (naive), O(log(n)) auxiliary (Sedgewick 1978)
 * 
 * */

import java.util.Arrays;

public class QuickSort
{
    public static void main(String[] args)
    {
        int[] array = RandomList.generate();
        System.out.println("Generated array: " + Arrays.toString(array));
        sort(array, 0, array.length-1);
        System.out.println("Sorted array: " + Arrays.toString(array));
    }

    public static void sort(int[] array, int left, int right)
    {
        if (left < right) {

            // Pivot is chosen randomly among the elements corresponding the array section we are working on
            int pivot_index = (int)(Math.random()*(right-left+1) + left);

            // Swap pivot with leftmost element corresponding to the array section we're working on
            Helper.swap(pivot_index, left, array);

            // Change the pivot index accordingly
            pivot_index = left;
            
            // i tracks the leftmost element bigger than the pivot 
            int i = left + 1;

            // Partitioning
            for (int j = left + 1; j <= right; j++)
                if (array[j] < array[pivot_index]) { //swap
                    Helper.swap(i, j, array);
                    i++;
                }

            // Final swap of the pivot with the rightmost element in the left partitioned section of the array
            Helper.swap(pivot_index, i-1, array);

            // Recurse on the left side (without the pivot)
            sort(array, left, i-2);

            // Recurse on the right side
            sort(array, i, right);
        }
    }
}
