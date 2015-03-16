
/*
 * Seek whether an integer is prime or composite
 * */

#include <iostream>
#include <cmath>
using namespace std;

int main() {

    int n;

    do {
        cout << "Enter integer > 1: "; cin >> n;
    } while (n < 2);

    double square_root = sqrt(n);

    bool is_prime = true;
    for (int i = 2; i <= square_root && is_prime; i++)
        if(n%i == 0)
            is_prime = false;

    if(is_prime)
        cout << n << " is prime" << endl;
    else
        cout << n << " is composite" << endl;

}

