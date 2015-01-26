//Author: Chafic Najjar
import java.util.Arrays;
public class BinarySearch {
    public static void main(String[] args) {
        int[] A = {1, 2, 4, 5, 7};
        System.out.println("found: " + search(A, 0, A.length-1, 4));
    }

    public static boolean search(int[] A, int low, int high, int key) {
        if (low > high)
            return false;
        int mid = (low+high)/2;

        System.out.println("Low: " + low);
        System.out.println("Mid: " + mid);
        System.out.println("High: "+ high);
        System.out.println("Array: " + Arrays.toString(Arrays.copyOfRange(A, low, high+1)));

        if(A[mid] == key)
            return true;

        else if(key < A[mid])
            return search(A, low, mid-1, key);

        else
            return search(A, mid+1, high, key);
    }
}
