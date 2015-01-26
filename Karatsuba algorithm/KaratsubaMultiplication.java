//Author: Chafic Najjar

//Works with all integers

import java.lang.Math;

public class KaratsubaMultiplication {
    public static void main(String[] args) {
        int x = 23975, y = 245; //answer: 5873875
        multiply(x, y);
    }

    public static int multiply(int x, int y) {
        String X = x + "";
        String Y = y + "";

        if (X.length() == 1 || Y.length() == 1)
            return x*y;
        
        else {
            
            //add zeros to even out the number of digits between both integers
            if (X.length() < Y.length())
                while(X.length() < Y.length())
                    X = "0" + X;
            else if (X.length() > Y.length())
                while (X.length() > Y.length())
                    Y = "0" + Y;
            System.out.println("X: " + X);
            System.out.println("Y: " + Y);

            int a = Integer.parseInt( X.substring( 0, X.length()/2) ) ;
            int b = Integer.parseInt( X.substring( X.length()/2, X.length()) ) ;
            int c = Integer.parseInt( Y.substring( 0, Y.length()/2) ) ;
            int d = Integer.parseInt( Y.substring( Y.length()/2, Y.length()) ) ;


            int ac = multiply(a, c);
            int bd = multiply(b, d);
            
            int temp = multiply(a+b, c+d);
            int ad_plus_bc = temp - ac - bd;
            
            //x*y = 10^n*ac + 10^(n/2)*(ad+bc) + bd

            int n = X.length() + (int)( 1 + Math.pow(-1, X.length()+1) )/2;

            int w = (int)(Math.pow(10, n)*ac) + (int)(Math.pow(10, n/2)*ad_plus_bc) + bd;
            System.out.println("w: " + w);
            return w;
        }
    }
}
