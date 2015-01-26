
/* Randomly generates a list of numbers from 0 to 99
 * Test suite for sorting programs
 * */

import java.lang.Math;
import java.util.Scanner;
import java.util.Arrays;

public class RandomList {

    public RandomList() {}

    public static int[] generate() {
        
        Scanner scan = new Scanner(System.in);
        System.out.println("How many numbers should the list contain?");
        int size = scan.nextInt();
        int[] array = new int[size];

        for (int i = 0; i < size; i++)
            array[i] = (int)(Math.random()*100);

        return array;
    }
}
