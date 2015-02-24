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
    const int SIZE = 30;
    int array[SIZE];

    srand(time(NULL)); 

    // Selection sort
    generate(array, SIZE);
    std::cout << "Generated array: ";
    print(array, SIZE);
    selection_sort(array, SIZE);
    std::cout << "Sorted array: ";
    print(array, SIZE);
    std::cout << std::endl;

    // Insertion sort
    generate(array, SIZE);
    std::cout << "Generated array: ";
    print(array, SIZE);
    insertion_sort(array, SIZE);
    std::cout << "Sorted array: ";
    print(array, SIZE);
    std::cout << std::endl;

    // Bubble sort
    generate(array, SIZE);
    std::cout << "Generated array: ";
    print(array, SIZE);
    bubble_sort(array, SIZE);
    std::cout << "Sorted array: ";
    print(array, SIZE);
    std::cout << std::endl;

    // Quick sort
    generate(array, SIZE);
    std::cout << "Generated array: ";
    print(array, SIZE);
    quick_sort(array, 0, SIZE-1);
    std::cout << "Sorted array: ";
    print(array, SIZE);
    std::cout << std::endl;

    // Shell sort
    generate(array, SIZE);
    std::cout << "Generated array: ";
    print(array, SIZE);
    shell_sort(array, SIZE);
    std::cout << "Sorted array: ";
    print(array, SIZE);
    std::cout << std::endl;

    // Merge sort
    generate(array, SIZE);
    std::cout << "Generated array: ";
    print(array, SIZE);
    int array2[SIZE];
    merge_sort(array, array2, 0, SIZE-1);
    std::cout << "Sorted array: ";
    print(array, SIZE);
    std::cout << std::endl;

    // Heap sort
    generate(array, SIZE);
    std::cout << "Generated array: ";
    print(array, SIZE);
    heap_sort(array, SIZE);
    std::cout << "Sorted array: ";
    print(array, SIZE);
    std::cout << std::endl;

    return 0;
}
