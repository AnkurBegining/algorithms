//Author: Chafic Najjar
//only works for when dimensions of square array are a power of 2

import java.util.Arrays;

public class Strassen {
    public static void main(String[] args) {
        double[][] first_array = { {1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16} };
        double[][] second_array = { {1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16} };

        //int[][] first_array = { {1, 2}, {3, 4} };
        //int[][] second_array = { {3, 4}, {1, 2} };

        for (int i = 0; i < first_array.length; i++)
            System.out.println( Arrays.toString (multiply(first_array, second_array)[i]) );

    }

    public static double[][] multiply(double[][] a, double[][] b) {
        
        int n = a.length;

        if (n == 1) {
            double[][] one_element_array = {{a[0][0]*b[0][0]}};
            return one_element_array;
        }

        double[][] A, B, C, D, E, F, G, H, P1, P2, P3, P4, P5, P6, P7, first_quandrant, second_quandrant, third_quandrant, fourth_quandrant;

        A = new double[n/2][n/2];
        B = new double[n/2][n/2];
        C = new double[n/2][n/2];
        D = new double[n/2][n/2];
        
        E = new double[n/2][n/2];
        F = new double[n/2][n/2];
        G = new double[n/2][n/2];
        H = new double[n/2][n/2];

        //divide a into four quadrants
        for (int i = 0; i < n/2; i++)
            for (int j = 0; j < n/2; j++) {
                A[i][j] = a[i][j];
                B[i][j] = a[i][j + n/2];
                C[i][j] = a[i + n/2][j];
                D[i][j] = a[i + n/2][j + n/2];
            }

        //divide b into four quadrants
        for (int i = 0; i < n/2; i++)
            for (int j = 0; j < n/2; j++) {
                E[i][j] = b[i][j];
                F[i][j] = b[i][j + n/2];
                G[i][j] = b[i + n/2][j];
                H[i][j] = b[i + n/2][j + n/2];
            }


        P1 = multiply( A, subtract(F, H) ); 
        P2 = multiply( add(A, B), H); 
        P3 = multiply( add(C, D), E); 
        P4 = multiply( D, subtract(G, E) );
        P5 = multiply( add(A, D), add(E, H) );
        P6 = multiply( subtract(B, D), add(G, H) );
        P7 = multiply( subtract(A, C), add(E, F) );


        first_quandrant = add( subtract( add(P5, P4), P2 ), P6 );
        
        second_quandrant = add(P1, P2);

        third_quandrant = add(P3, P4);

        fourth_quandrant = subtract( subtract( add(P1, P5), P3 ), P7 );

        //glue back the 4 quadrants
        double[][] answer = new double[n][n];

        for (int i = 0; i < n/2; i++)
            for (int j = 0; j < n/2; j++) {
                answer[i][j] = first_quandrant[i][j];
                answer[i][j + n/2] = second_quandrant[i][j];
                answer[i + n/2][j] = third_quandrant[i][j];
                answer[i + n/2][j + n/2] = fourth_quandrant[i][j];
            }

        return answer;
    }

    public static double[][] add(double[][] A, double[][] B) {
        int n = A.length;
        double[][] C = new double[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                C[i][j] = A[i][j]+B[i][j];

        return C;
    }

    public static double[][] subtract(double[][] A, double[][] B) {
        int n = A.length;
        double[][] C = new double[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                C[i][j] = A[i][j]-B[i][j];

        return C;
    }
}
