#include "SelectionSort.hpp"
#include "InsertionSort.hpp"
#include "BubbleSort.hpp"
#include "QuickSort1.hpp"
#include "QuickSort2.hpp"
#include "RandomizedQuickSort.hpp"
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

    std::cout << "Selection sort" << std::endl;
    generate(array, SIZE);
    print(array, SIZE);
    selection_sort(array, SIZE);
    print(array, SIZE);
    std::cout << std::endl;

    std::cout << "Insertion sort" << std::endl;
    generate(array, SIZE);
    print(array, SIZE);
    insertion_sort(array, SIZE);
    print(array, SIZE);
    std::cout << std::endl;

    std::cout << "Bubble sort" << std::endl;
    generate(array, SIZE);
    print(array, SIZE);
    bubble_sort(array, SIZE);
    print(array, SIZE);
    std::cout << std::endl;

    std::cout << "Quick sort 1" << std::endl;
    generate(array, SIZE);
    print(array, SIZE);
    quick_sort1(array, 0, SIZE-1);
    print(array, SIZE);
    std::cout << std::endl;

    std::cout << "Quick sort 2" << std::endl;
    generate(array, SIZE);
    print(array, SIZE);
    quick_sort2(array, 0, SIZE-1);
    print(array, SIZE);
    std::cout << std::endl;

    std::cout << "Randomized quick sort" << std::endl;
    generate(array, SIZE);
    print(array, SIZE);
    randomized_quick_sort(array, 0, SIZE-1);
    print(array, SIZE);
    std::cout << std::endl;

    std::cout << "Shell sort" << std::endl;
    generate(array, SIZE);
    print(array, SIZE);
    shell_sort(array, SIZE);
    print(array, SIZE);
    std::cout << std::endl;

    std::cout << "Merge sort" << std::endl;
    generate(array, SIZE);
    print(array, SIZE);
    int array2[SIZE];
    merge_sort(array, array2, 0, SIZE-1);
    print(array, SIZE);
    std::cout << std::endl;

    std::cout << "Heap sort" << std::endl;
    generate(array, SIZE);
    print(array, SIZE);
    heap_sort(array, SIZE);
    print(array, SIZE);
    std::cout << std::endl;

    return 0;
}
