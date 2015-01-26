#include "SelectionSort.hpp"
#include "InsertionSort.hpp"
#include "BubbleSort.hpp"
#include "QuickSort.hpp"
#include "ShellSort.hpp"
#include "MergeSort.hpp"
#include "HeapSort.hpp"
#include "Helper.hpp"
#include <iostream>

int main()
{
    int size = 30;
    int array[size];
    generate(array, size);
    print(array, size);

    selection_sort(array, size);
    print(array, size);

    //insertion_sort(array, size);
    //print(array, size);

    //bubble_sort(array, size);
    //print(array, size);

    //quick_sort(array, 0, size-1);
    //print(array, size);

    //shell_sort(array, size); 
    //print(array, size);

    //int array2[size];
    //merge_sort(array, array2, 0, size-1);
    //print(array, size);

    //heap_sort(array, size);
    //print(array, size);

    return 0;
}
