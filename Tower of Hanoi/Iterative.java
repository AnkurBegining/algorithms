/*
    Author: Chafic Najjar
    Description: Implementations of iterative and recursive solutions for the Tower of Hanoi.
*/

import java.util.Scanner;

public class Iterative {
    
    private static int direction_selector; //selects direction of smallest disc according to whether the total number of discs even or odd
    private static int[] disc_position_of; //stores position of each disc. First tower from left is 0, second is 1 and third is 2
    
    public Iterative() {
        direction_selector = 0;
    }

    public static void main(String[] args) {
        
        //invokes constructor
        Iterative o = new Iterative();

        Scanner scan = new Scanner(System.in);
        
        System.out.println("Enter number of n: ");
        int n = scan.nextInt();

        disc_position_of = new int[n];
        
        //initial position of all disks is 0
        for (int i = 0; i < n; i++) {
            disc_position_of[i] = 0;
        }
        
        //checks if even or odd
        direction_selector = evenOrOdd(n);  

        towerOfHanoi(n);
    }

    public static void towerOfHanoi(int n) {

        for (int i = 0; i < (Math.pow(2, n)-1)/2; i++) {

            //moves smallest disc left or right depending on whether total the number of discs even or odd
            System.out.print("Disc 1 moved from tower " + (disc_position_of[0]+1)); //will print 0+1=1
            disc_position_of[0] = (disc_position_of[0] + direction_selector) % 3; //will be print 0, 1 or 2
            System.out.println(" to tower " + (disc_position_of[0]+1)); //will print 1 or 3
            
            //For easier understanding, let's call TOWER1 and TOWER2 the first and second towers which do not hold the smallest disc

            boolean first_is_empty = true, second_is_empty = true; //indicators for TOWER1 and TOWER2 
            int smallest1 = 0, smallest2 = 0; //smallest1 and smallest2 store smallest discs of TOWER1 and TOWER2
            
            //checks if TOWER1 is empty
            for (int j = 0; j < n; j++)
                if ( disc_position_of[j] == (disc_position_of[0]+1)%3 ) {
                    first_is_empty = false;
                    smallest1 = j;
                    j = n; //breaks out of the loop
                }

            //checks if TOWER2 is empty
            for (int j = 0; j < n; j++)
                if ( disc_position_of[j] == (disc_position_of[0]+2)%3 ) {
                    second_is_empty = false;
                    smallest2 = j;
                    j = n; //breaks out of the loop
                }

            if (first_is_empty) {   
                //checks for the smallest disc in TOWER2 and sends it to TOWER1
                for (int j = 0; j < n; j++)
                    if (disc_position_of[j] == (disc_position_of[0]+2)%3) {
                        System.out.print("Disc " + (j+1) + " moved from tower " + (disc_position_of[j]+1));
                        disc_position_of[j] = (disc_position_of[0]+1)%3;
                        System.out.println(" to tower " + (disc_position_of[j]+1));
                        j = n; //breaks out of the loop
                    }
            }

            else if(second_is_empty) {
                //checks for the smallest disc in TOWER1 and sends it to TOWER2
                for (int j = 0; j < n; j++)
                    if (disc_position_of[j] == (disc_position_of[0]+1)%3) {
                        System.out.print("Disc " + (j+1) + " moved from tower " + (disc_position_of[j]+1));
                        disc_position_of[j] = (disc_position_of[0]+2)%3;
                        System.out.println(" to tower " + (disc_position_of[j]+1));
                        j = n; //breaks out of the loop
                    }
            }

            else { //if none is empty, move smallest disc among TOWER1 and TOWER2 from its tower the the other
                if (smallest1 < smallest2) {
                    System.out.print("Disc " + (smallest1+1) + " moved from tower " + (disc_position_of[smallest1]+1));
                    disc_position_of[smallest1] = disc_position_of[smallest2];
                    System.out.println(" to tower " + (disc_position_of[smallest2]+1));
                }
                
                else {
                    System.out.print("Disc " + (smallest2+1) + " moved from tower " + (disc_position_of[smallest2]+1));
                    disc_position_of[smallest2] = disc_position_of[smallest1];
                    System.out.println(" to tower " + (disc_position_of[smallest1]+1));
                }
            }
        }
    }

    public static int evenOrOdd(int n) {
        if (n%2 == 0)
            return 1;
        else
            return 2;
    }

}
