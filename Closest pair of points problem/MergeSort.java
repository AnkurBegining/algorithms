//Author: Chafic Najjar

import java.util.Arrays;

public class MergeSort {

    public MergeSort() {}

    public static Point[] xSort(Point[] P) {
        
        if (P.length <= 1)
            return P;
        else {      
            Point[] P1 = xSort( Arrays.copyOfRange(P, 0, P.length/2) );
            Point[] P2 = xSort( Arrays.copyOfRange(P, P.length/2, P.length) );
            return xMerge(P1, P2);
        }
    }

    public static Point[] xMerge(Point[] P1, Point[] P2) {
        
        Point[] D = new Point[P1.length+P2.length];

        for (int i = 0, j = 0, k = 0; i != P1.length || j != P2.length; k++) { //or as a condition (k < P1.length+P2.length)
        
            if (i == P1.length) {
                while (j != P2.length) {
                    D[k] = P2[j];
                    j++;
                    k++;
                }
            }
            
            else if (j == P2.length) {
                while (i != P1.length) {
                    D[k] = P1[i];
                    i++;
                    k++;
                }
            }
            
            else {
                if (P1[i].getX() < P2[j].getX()) {
                    D[k] = P1[i];
                    i++;
                }

                else {
                    D[k] = P2[j];
                    j++;
                }
            }
        }
        return D;
    }

    public static Point[] ySort(Point[] P) {
        
        if (P.length <= 1)
            return P;
        else {      
            Point[] P1 = ySort( Arrays.copyOfRange(P, 0, P.length/2) );
            Point[] P2 = ySort( Arrays.copyOfRange(P, P.length/2, P.length) );
            return yMerge(P1, P2);
        }
    }

    public static Point[] yMerge(Point[] P1, Point[] P2) {
        
        Point[] D = new Point[P1.length+P2.length];

        for (int i = 0, j = 0, k = 0; i != P1.length || j != P2.length; k++) { //or as a condition (k < P1.length+P2.length)
        
            if (i == P1.length) {
                while (j != P2.length) {
                    D[k] = P2[j];
                    j++;
                    k++;
                }
            }
            
            else if (j == P2.length) {
                while (i != P1.length) {
                    D[k] = P1[i];
                    i++;
                    k++;
                }
            }
            
            else {
                if (P1[i].getY() < P2[j].getY()) {
                    D[k] = P1[i];
                    i++;
                }

                else {
                    D[k] = P2[j];
                    j++;
                }
            }
        }
        return D;
    }
}
