#ifndef HELPER_HPP
#define HELPER_HPP

#include <iostream>
#include <ctime>
#include <cstdlib>

void generate(int array[], int amount)
{
    srand(time(NULL)); 

    for (int i = 0; i < amount; i++)
        array[i] = rand()%100;
}

void swap(int array[], int i, int j)
{
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
}

void print(int array[], int size)
{
    for (int i = 0; i < size; i++)
        std::cout << array[i] << ( (i != size-1) ? ", " : "");
    std::cout << std::endl << std::endl;
}

#endif // HELPER_HPP
