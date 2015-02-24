
/* Bubble sort 
 * 
 * Worst case performance is O(n^2)
 * Best case performance is O(n)
 * Average case performance is O(n^2)
 * 
 * */

import java.util.Arrays;

public class BubbleSort {
    
    public static void main(String[] args) {

        int[] array = RandomList.generate();
        System.out.println("Generated array: " + Arrays.toString(array));
        sort(array);
        System.out.println("Sorted array: " + Arrays.toString(array));

    }
    
    public static void sort(int[] array) {
        boolean swap = true;
        int length = array.length;
        while(swap) {
            swap = false;
            for (int i = 0; i < length-1; i++)
                if(array[i] > array[i+1]) {
                    Helper.swap(i, i+1, array);
                    swap = true;
                }
            length--;
        }
        
    }

}
