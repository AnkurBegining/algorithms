
/*
 * Test whether two integers are coprime or not
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

    cout << "First integer (a > 1): "; cin >> a;
    cout << "Second integer (b > 1): "; cin >> b;

    if (b > a) {
        int temp = a;
        a = b;
        b = temp;
    }

    int GCD = gcd(a, b);
    if( GCD == 1)
        cout << a << " and " << b << " are coprime" << endl;
    else {
        cout << a << " and " << b << " are not coprime" << endl; 
        cout << "GCD: " << GCD << endl;
    }

}
