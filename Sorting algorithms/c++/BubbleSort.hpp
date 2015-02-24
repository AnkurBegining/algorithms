#include "Helper.hpp"

/* Bubble sort 
 * 
 * Worst case performance is O(n^2)
 * Best case performance is O(n)
 * Average case performance is O(n^2)
 * Worst case space complexity is O(1) auxiliary
 * 
 * */

void bubble_sort(int array[], int size)
{
    bool sorted = false;
    while(!sorted) {
        sorted = true;
        for (int i = 0; i < size-1; i++)
            if (array[i+1] < array[i]) {
                swap(array[i+1], array[i]);
                sorted = false;
            }
    }
}
