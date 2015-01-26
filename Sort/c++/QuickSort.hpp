#include "Helper.hpp"

/* Randomized Quicksort 
 * 
 * Worst case performance is O(nlog(n))
 * Best case performance is O(nlog(n))
 * Average case performance is O(nlog(n))
 * 
 * */

void quick_sort(int array[], int low, int high)
{
    int pivot = array[(low+high)/2];

    int i = low;
    int j = high;

    while (i <= j) {
        while (array[i] < pivot)
            i++;
        while (array[j] > pivot)
            j--;

        if (i <= j) {
            swap(array, i, j);
            i++;
            j--;
        }
    }

    if (low < j)
        quick_sort(array, low, j);

    if (i < high)
        quick_sort(array, i, high);
}
