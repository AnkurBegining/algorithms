/*
Author: Chafic Najjar
Description: Solves Tower of Hanoi recursively. Algoritm is hand-made
*/

import java.util.Scanner;

public class Recursive2 {
    static int sign;
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter number of disks: ");
        int input = scan.nextInt();
        
        //checks if even or odd, decides first direction
        if (input%2 == 0)
            sign = 1;
        else 
            sign = -1;

        hanoi(input);
    }

    public static void hanoi(int n) {
        //alternates the direction for each disc
        int i = (int)Math.pow(-1, n)*sign;
        
        if (n == 1)
            System.out.println("Disc 1: " + (i == 1 ? "left" : "right"));
        else {
            hanoi(n-1);
            System.out.println("Disc " + n + ": " + (i == 1 ? "left" : "right")); //depends on 2 things, if n is even or odd and where we're at now (this calls for an alternation)
            hanoi(n-1);
        }
    }
}
