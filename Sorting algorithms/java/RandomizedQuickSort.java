
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
            int p = parition(array, low, high);
            sort(array, low, p-1);
            sort(array, p+1, high);
        }
    }

    public static int parition(int[] array, int low, int high)
    {
        int pivotIndex = (int)(Math.random()*(high-low+1) + low);
        int pivotValue = array[pivotIndex];

        Helper.swap(pivotIndex, high, array);

        int storeIndex = low;

        for (int i = low; i < high; i++)
            if (array[i] < pivotValue)
                Helper.swap(i, storeIndex++, array);

        Helper.swap(storeIndex, high, array);

        return storeIndex;
    }

}
