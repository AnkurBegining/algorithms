//Author: Chafic Najjar

import java.util.Arrays;

public class CountingInversions {
    
    public static void main(String args[]) {
        
        int[] array = RandomList.generate();
        
        System.out.println( "Generated array: " + Arrays.toString(array) );

        System.out.println( "Number of inversions: " + sort_and_count(array) );

    }
    
    public static int sort_and_count (int A[]) {
        if (A.length <= 1)
            return 0;

        else {

            int left[] = Arrays.copyOfRange(A, 0, (A.length + 1) / 2);
            int right[] = Arrays.copyOfRange(A, (A.length + 1) / 2, A.length);
            
            return sort_and_count(left) + sort_and_count(right) + merge_and_count_split_inversion(A, left, right);
        }
    }

    public static int merge_and_count_split_inversion(int A[], int B[], int[] C) {
        int count = 0;
        for (int i = 0, j = 0, k = 0; i != B.length || j != C.length; k++) {
        
            if (i == B.length) {
                while (j != C.length) {
                    A[k] = C[j];
                    j++;
                    k++;
                }
            }
            
            else if (j == C.length) {
                while (i != B.length) {
                    A[k] = B[i];
                    i++;
                    k++;
                }
            }
            
            else {
                if (B[i] < C[j]) {
                    A[k] = B[i];
                    i++;
                }

                else {
                    A[k] = C[j];
                    count += B.length-i;
                    j++;
                }
            }
        }
        return count;

        //return number of split inversion
    }
}
