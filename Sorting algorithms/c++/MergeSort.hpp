#include "Helper.hpp"

/* Merge sort
 * 
 * Worst case performance is O(nlog(n));
 * Best case performance is O(nlog(n)) typical
 * Average case performance is O(nlog(n))
 * Worst case space complexity O(n) auxiliary
 * 
 * */

void merge(int A[], int B[], int low, int mid, int high)
{
    for (int i = low, j = mid+1, k = low; i <= mid || j <= high;) {
        if (!(i <= mid))
            while (j <= high)
                B[k++] = A[j++];

        else if (!(j <= high))
            while (i <= mid)
                B[k++] = A[i++];

        else {
            if (A[i] < A[j])
                B[k++] = A[i++];

            else // A[i] > A[j]
                B[k++] = A[j++];
        }
    }
}

void merge_sort(int A[], int B[], int low, int high)
{
    if (low == high)
        return;

    int mid = (low+high)/2;
    merge_sort(A, B, low, mid);
    merge_sort(A, B, mid+1, high);
    merge(A, B, low, mid, high);

    // Copy array
    for (int i = low; i <= high; i++)
        A[i] = B[i];
}
