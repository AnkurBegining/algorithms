//Author: Chafic Najjar

import java.util.Arrays;
import java.lang.Math;
import java.util.ArrayList;

public class ClosestPair {
    public static void main(String[] args) {
        //input all the points store in array of points
        final int NUMBER_OF_POINTS = 10;
        Point[] Px = new Point[NUMBER_OF_POINTS];
        Point[] Py = new Point[NUMBER_OF_POINTS];

        double[] x = {-5, 5, 1, 6, -3, -3, 3, -3, 5, -10};
        double[] y = {5, 6, 2, 5, 3, 0, -4, -4, -1, 8};

        for (int i = 0; i < 10; i++)
            Py[i] = Px[i] = new Point(x[i], y[i]);
        
        //sort points according to x and y using merge sort
        
        Px = MergeSort.xSort(Px);
        Py = MergeSort.ySort(Py);

        System.out.println( closestPair(Px, Py) );
        
        //closestSplitPair(Px, Py, 6);

    }

    public static Pair closestPair(Point[] Px, Point[] Py) {
        if (Px.length == 2) {
            return new Pair(Px[0], Px[1]);
        }
        else if(Px.length <= 3) {
            
            //compute all euclidean distances and return smallest (or the points)
            
            double first = Px[0].distance(Px[1]);
            double second = Px[1].distance(Px[2]);
            double third = Px[2].distance(Px[0]);

            //return closest pair and distance
            Pair closest_pair;
            if (first < second)
                if (first < third)
                    closest_pair = new Pair(Px[0], Px[1]);
                else
                    closest_pair = new Pair(Px[2], Px[0]);
            else
                if (second < third)
                    closest_pair = new Pair(Px[1], Px[2]);
                else
                    closest_pair = new Pair(Px[2], Px[0]);
            
            return closest_pair;
        }

        else {

            Point[] Qx = Arrays.copyOfRange(Px, 0, Px.length/2);
            Point[] Qy = Arrays.copyOfRange(Py, 0, Py.length/2);
            Point[] Rx = Arrays.copyOfRange(Px, Px.length/2, Px.length);
            Point[] Ry = Arrays.copyOfRange(Py, Py.length/2, Py.length);


            Pair closest_pair1 = closestPair(Qx, Qy);
            Pair closest_pair2 = closestPair(Rx, Ry);

            //smallest distance between the 2 smallest distances of each side
            Pair closest_pair;
            if (closest_pair1.getDistance() < closest_pair2.getDistance())
                closest_pair = closest_pair1;
            else
                closest_pair = closest_pair2;

            //find the smallest distance
            
            Pair split_closest_pair = closestSplitPair(Px, Py, closest_pair.getDistance());

            if(split_closest_pair.getDistance() < closest_pair.getDistance())
                return split_closest_pair;
            else
                return closest_pair;

        }
        
    }
    
    public static Pair closestSplitPair(Point[] Px, Point[] Py, double delta) {

        //take the biggest x coordinate in the left of P
        int x = (Px.length-1)/2;

        //check in Py where the points with x coordinates between x-delta and x+delta and copy them in Sy
        ArrayList<Point> Sy_arraylist = new ArrayList<Point>();
        //Point[] Sy = new Point[9];
        for (int i = 0; i < Py.length; i++) {
            if (Py[i].getX() < x+delta && Py[i].getX() > x-delta)
                Sy_arraylist.add(Py[i]);
        }

        Point[] Sy = new Point[Sy_arraylist.size()];
        for (int i = 0; i < Sy_arraylist.size(); i++)
            Sy[i] = Sy_arraylist.get(i);

        
        double best_distance = delta;
        Pair best_pair = new Pair(new Point(0, 0), new Point(9999, 9999));

        for (int i = 0; i < Sy.length; i++) //maybe it should be Sy.length-7
            for (int j = 1; j <= 7 && (i+j) < Sy.length-1; j++) {
                double the_new_distance = Sy[i].distance(Sy[i+j]);
                if (the_new_distance < best_distance) {
                    best_distance = the_new_distance;
                    best_pair = new Pair(Sy[i], Sy[i+j]);
                }
            }

        return best_pair;
    }
}
