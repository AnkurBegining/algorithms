#include "Helper.hpp"

void shell_sort(int array[], int size) {
    for (int gap = size/2; gap != 0; gap = gap/2)  
        for (int i = 0; i < size-gap; i++)
            for (int j = i+gap; array[j] < array[j-gap] && j-gap >= 0; j = j-gap)
                swap(array, j, j-gap);
}
