
/*
 * Find the greatest common divisor (gcd) of two integers using Euclid's algorithms
 */

#include <iostream>
using namespace std;

int gcd(int a, int b) {

    if (b == 0)
        return a; 

    return gcd(b, a%b);

}

int main() {
    
    int a, b;

    cout << "a: "; cin >> a;
    cout << "b: "; cin >> b;

    if (b > a) {
        int temp = a;
        a = b;
        b = temp;
    }

    cout << "GCD: " << gcd(a, b) << endl;

    return 0;

}


