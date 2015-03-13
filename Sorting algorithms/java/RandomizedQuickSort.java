
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

public class RandomizedQuickSort
{
    public static void main(String[] args)
    {
        int[] array = RandomList.generate();
        System.out.println("Generated array: " + Arrays.toString(array));
        sort(array, 0, array.length-1);
        System.out.println("Sorted array: " + Arrays.toString(array));
    }

    public static void sort(int[] array, int low, int high)
    {
        if (low < high) {

            // Pivot is chosen randomly among the elements corresponding the array section we are working on
            int pivot_index = (int)(Math.random()*(high-low+1) + low);

            // Swap pivot with lowmost element corresponding to the array section we're working on
            Helper.swap(pivot_index, low, array);

            // Change the pivot index accordingly
            pivot_index = low;
            
            // i tracks the lowmost element bigger than the pivot 
            int i = low + 1;

            // Partitioning
            for (int j = low + 1; j <= high; j++)
                if (array[j] < array[pivot_index]) { //swap
                    Helper.swap(i, j, array);
                    i++;
                }

            // Final swap of the pivot with the highmost element in the low partitioned section of the array
            Helper.swap(pivot_index, i-1, array);

            // Recurse on the low side (without the pivot)
            sort(array, low, i-2);

            // Recurse on the high side
            sort(array, i, high);
        }
    }
}
