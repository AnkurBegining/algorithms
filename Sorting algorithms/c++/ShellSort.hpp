#include "Helper.hpp"

/* Shell sort
 * 
 * Worst case performance is O(n^2)
 * Best case performance is O(nlog^2(n))
 * Average case performance depends on gap sequence
 * For gap = N/2^k, worst-case performance is O(n^2)
 * Worst case space complexity is O(n) total, O(1) auxiliary
 * 
 * */

void shell_sort(int array[], int size)
{
    for (int gap = size/2; gap != 0; gap = gap/2)  
        for (int i = 0; i < size-gap; i++)
            for (int j = i+gap; array[j] < array[j-gap] && j-gap >= 0; j = j-gap)
                swap(array[j], array[j-gap]);
}
