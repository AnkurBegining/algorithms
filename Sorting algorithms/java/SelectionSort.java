
/* Selection sort 
 * 
 * Worst case performance is O(n^2)
 * Best case performance is O(n^2)
 * Average case performance is O(n^2)
 * Worst case space complexity is O(n) total, O(1) auxiliary
 * 
 * */

import java.util.Arrays;

public class SelectionSort
{
    public static void main(String[] args)
    {
        int[] array = RandomList.generate();
        System.out.println("Generated array: " + Arrays.toString(array));
        sort(array);
        System.out.println("Sorted array: " + Arrays.toString(array));
    }
    
    public static void sort(int[] array)
    {
        for (int i = 0; i < array.length-1; i++) {
            int index_of_smallest = i;
            for (int j = i+1; j < array.length; j++)
                if (array[index_of_smallest] > array[j])
                    index_of_smallest = j;

            Helper.swap(i, index_of_smallest, array);
        }
    }
}
