#include "Helper.hpp"

/* Selection sort 
 * 
 * Worst case performance is O(n^2)
 * Best case performance is O(n^2)
 * Average case performance is O(n^2)
 * Worst case space complexity is O(n) total, O(1) auxiliary
 * 
 * */

void selection_sort(int array[], int size)
{
    for (int i = 0; i < size-1; i++) {
        int index_smallest = i;
        for (int j = i+1; j < size; j++)
            if (array[j] < array[index_smallest])
                index_smallest = j;
        swap(array[i], array[index_smallest]);
    }
}


