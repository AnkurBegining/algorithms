#ifndef HELPER_HPP
#define HELPER_HPP

#include <iostream>
#include <ctime>
#include <cstdlib>

void generate(int array[], int amount)
{
    for (int i = 0; i < amount; i++)
        array[i] = rand()%100;
}

void swap(int &a, int &b)
{
    int temp = a;
    a = b;
    b = temp;
}

void print(int array[], int size)
{
    std::cout << "[ ";
    for (int i = 0; i < size; i++)
        std::cout << array[i] << ( (i != size-1) ? ", " : "");
    std::cout << " ]" << std::endl;
}

#endif // HELPER_HPP
