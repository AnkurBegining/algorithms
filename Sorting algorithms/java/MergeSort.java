
/* Merge sort
 * 
 * Worst case performance is O(nlog(n));
 * Best case performance is O(nlog(n)) typical, O(n) natural variant
 * Average case performance is O(nlog(n))
 * Worst case space complexity O(n) auxiliary
 * 
 * */

import java.util.Arrays;
public class MergeSort {

    private static int comparison_number;

    public MergeSort() {
        comparison_number = 0;
    }

    public static void main(String[] args) {
        
        int[] A = RandomList.generate();
        System.out.println("Generated array: " + Arrays.toString(A));
        sort(A, 0, A.length-1, new int[A.length]);
        System.out.println( "Sorted array: " + Arrays.toString(A)); 
        System.out.println("Number of comparisons: " + comparison_number);
    }

    public static void sort(int[] A, int low, int high, int[] B) {

        if (low != high) {

            int mid = (low+high)/2;
            sort( A, low, mid, B );
            sort( A, mid+1, high, B );
            merge( A, low, mid, high, B );
            System.arraycopy( B, low, A, low, high-low+1 );

        }
    }

    public static void merge(int[] A, int low, int mid, int high, int[] B) {
        
        for (int i = low, j = mid+1, k = low; i < mid+1 || j < high+1; k++) {

            if (i == mid+1) 
                while (j < high+1) {
                    B[k] = A[j];
                    j++;
                    k++;
                    comparison_number++;
                }

            else if (j == high+1)
                while (i < mid+1) {
                    B[k] = A[i];
                    i++;
                    k++;
                    comparison_number++;
                }

            else
                if (A[i] < A[j]) {
                    B[k] = A[i];
                    i++;
                    comparison_number++;
                }

                else {
                    B[k] = A[j];
                    j++;
                    comparison_number++;
                }
        }

    }
}
