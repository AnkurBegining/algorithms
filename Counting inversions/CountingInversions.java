//Author: Chafic Najjar

import java.util.Arrays;

public class CountingInversions {
    
    public static void main(String args[]) {
        int[] array = RandomList.generate();
        System.out.println( "Generated array: " + Arrays.toString(array) );
        System.out.println( "Number of inversions: " + sortAndCount(array) );
    }
    
    public static int sortAndCount (int A[]) {
        if (A.length <= 1)
            return 0;

        int left[] = Arrays.copyOfRange(A, 0, (A.length + 1) / 2);
        int right[] = Arrays.copyOfRange(A, (A.length + 1) / 2, A.length);
        
        return sortAndCount(left) + sortAndCount(right) + mergeAndCountSplitInversions(A, left, right);
    }

    public static int mergeAndCountSplitInversions(int A[], int B[], int[] C) {
        int inversionCount = 0;
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
                    inversionCount += B.length-i;
                    j++;
                }
            }
        }
        return inversionCount;
    }
}
