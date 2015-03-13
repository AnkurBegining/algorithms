/* Quicksort 
 * 
 * Worst case performance is O(n^2)
 * Best case performance is O(nlog(n)) simple partition, O(n) (three-way partition and equal keys)
 * Average case performance is O(nlog(n))
 * Worst case space complexity O(n) auxiliary (naive), O(log(n)) auxiliary (Sedgewick 1978)
 * 
 * */

import java.util.Arrays;

public class QuickSort2
{
    public static void main(String[] args)
    {
        int[] array = RandomList.generate();
        System.out.println("Generated array: " + Arrays.toString(array));
        sort(array, 0, array.length-1);
        System.out.println("Sorted array: " + Arrays.toString(array));
    }

    public static void sort(int array[], int low, int high)
    {
        int pivot = array[(low+high)/2];

        int i = low;
        int j = high;

        while (i <= j) {
            while (array[i] < pivot)
                i++;
            while (array[j] > pivot)
                j--;

            if (i <= j)
                Helper.swap(i++, j--, array);
        }

        if (low < j)
            sort(array, low, j);

        if (i < high)
            sort(array, i, high);
    }
}
