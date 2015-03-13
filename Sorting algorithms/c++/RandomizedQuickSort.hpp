#include "Helper.hpp"

/* Randomized Quicksort 
 * 
 * Worst case performance is O(nlogn)
 * Best case performance is O(nlog(n)) simple partition, O(n) (three-way partition and equal keys)
 * Average case performance is O(nlog(n))
 * Worst case space complexity O(n) auxiliary (naive), O(log(n)) auxiliary (Sedgewick 1978)
 * 
 * */

#include <cstdlib>
#include <ctime>

int partition_random(int array[], int low, int high)
{
    std::srand(std::time(0));
    int pivotIndex = std::rand() % (high-low+1) + low;
    int pivotValue = array[pivotIndex];

    swap(array[pivotIndex], array[high]);

    int storeIndex = low;

    for (int i = low; i < high; i++)
        if (array[i] < pivotValue)
            swap(array[i], array[storeIndex++]);

    swap(array[storeIndex], array[high]);

    return storeIndex;
}

void randomized_quick_sort(int array[], int low, int high)
{

    if (low < high) {
        int p = partition_random(array, low, high);
        randomized_quick_sort(array, low, p-1);
        randomized_quick_sort(array, p+1, high);
    }
}
