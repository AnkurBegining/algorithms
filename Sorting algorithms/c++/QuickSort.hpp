#include "Helper.hpp"

/* Randomized Quicksort 
 * 
 * Worst case performance if randomized is O(nlogn)
 * Worst case performance if not randomized is O(n^2)
 * Best case performance is O(nlog(n)) simple partition, O(n) (three-way partition and equal keys)
 * Average case performance is O(nlog(n))
 * Worst case space complexity O(n) auxiliary (naive), O(log(n)) auxiliary (Sedgewick 1978)
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

        if (i <= j)
            swap(array[i++], array[j--]);
    }

    if (low < j)
        quick_sort(array, low, j);

    if (i < high)
        quick_sort(array, i, high);
}
