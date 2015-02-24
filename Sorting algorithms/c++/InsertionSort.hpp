#include "Helper.hpp"

/* Insertion sort 
 * 
 * Worst case performance is O(n^2) comparisons and swaps
 * Best case performance is O(n) comparisons, O(1) swaps
 * Average case performance is O(n^2) comparisons and swaps
 * Worst case space complexity is O(n) total, O(1) auxiliary
 * 
 * */

void insertion_sort(int array[], int size)
{
    for (int i = 1; i < size; i++)
        for (int j = i; j > 0 && array[j-1] > array[j]; j--)
               swap(array, j, j-1);
}

