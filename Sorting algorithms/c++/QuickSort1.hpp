#include "Helper.hpp"

/* Quicksort 
 * 
 * Worst case performance is O(n^2)
 * Best case performance is O(nlog(n)) simple partition, O(n) (three-way partition and equal keys)
 * Average case performance is O(nlog(n))
 * Worst case space complexity O(n) auxiliary (naive), O(log(n)) auxiliary (Sedgewick 1978)
 * 
 * */

int partition(int array[], int low, int high)
{
    int pivotIndex = (low+high)/2;
    int pivotValue = array[pivotIndex];

    swap(array[pivotIndex], array[high]);

    int storeIndex = low;

    for (int i = low; i < high; i++)
        if (array[i] < pivotValue)
            swap(array[i], array[storeIndex++]);

    swap(array[storeIndex], array[high]);

    return storeIndex;
}

void quick_sort1(int array[], int low, int high)
{

    if (low < high) {
        int p = partition(array, low, high);
        quick_sort1(array, low, p-1);
        quick_sort1(array, p+1, high);
    }
}
