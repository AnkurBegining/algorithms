#include "Helper.hpp"

/* Heap sort
 * 
 * Worst case performance is O(nlog(n))
 * Best case performance is O(nlog(n))
 * Average case performance is O(nlog(n))
 * Worst case space complexity is O(1) auxiliary
 * 
 * */

void swim(int array[], int i)
{
    while (i != 0 && array[i] > array[i/2]) {
        swap(array, i, i/2);
        i /= 2;
    }
}

void sink(int heap[], int size, int i)
{
    while (2*i <= size) {
        int j = 2*i;
        if (heap[j+1] > heap[j])
            j++;
        if (heap[i] < heap[j])
            swap(heap, i, j);
        i = j;
    }
}

void heapify(int array[], int heap[], int size)
{
    for (int i = 0; i < size; i++)
        swim(array, i);

    for (int i = 1; i < size+1; i++)
        heap[i] = array[i-1];
}

int removeMax(int heap[], int size, int last) 
{
    int max = heap[1];
    heap[1] = heap[last];
    heap[last] = 0;
    sink(heap, size, 1);
    return max;
}

void heap_sort(int array[], int size)
{
    int heap[size+1];
    heapify(array, heap, size);

    for (int i = 0; i < size; i++)
        array[size-1-i] = removeMax(heap, size+1, size-i);
}
