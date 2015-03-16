
/* Bubble sort 
 * 
 * Worst case performance is O(n^2)
 * Best case performance is O(n)
 * Average case performance is O(n^2)
 * Worst case space complexity is O(1) auxiliary
 * 
 * */

import java.util.Arrays;

public class BubbleSort
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
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < array.length-1; i++)
                if (array[i+1] < array[i]) {
                    Helper.swap(i, i+1, array);
                    sorted = false;
                }
        }
    }

    /*
    // Slightly faster version
    public static void sort(int[] array)
    {
        for (int j = array.length; j >= 0; j--)
            for (int i = 0; i < j-1; i++)
                if (array[i+1] < array[i])
                    Helper.swap(i, i+1, array);
    }
    /*
}
