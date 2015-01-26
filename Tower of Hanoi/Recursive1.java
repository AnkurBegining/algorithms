/*
    Author: Chafic Najjar
    Description: Implementation of a recursive solution for the Tower of Hanoi problem
*/

import java.util.Scanner;

public class Recursive1 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter number of n: ");
        int n = scan.nextInt();
        towerOfHanoi(n, 1, 2, 3);
    }

    public static void towerOfHanoi(int n, int start, int temp, int end) {
        if (n == 1)
            System.out.println("Move disc from " + start + " to " + end);
        else {
            towerOfHanoi(n-1, start, end, temp);
            System.out.println("Move disc from " + start + " to " + end);
            towerOfHanoi(n-1, temp, start, end);
        }
    }
}
