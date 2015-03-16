
/*
 * Compute least common multiple (lcm) using gcd (or euclid's algorithm?)
 */

#include <iostream>
using namespace std;

int gcd(int a, int b) {

    if (b == 0)
        return a; 

    return gcd(b, a%b);

}

int lcm(int a, int b) { return (a*b)/gcd(a, b); }

int main() {

    int a, b;
    cout << "a: "; cin >> a;
    cout << "b: "; cin >> b;

    if (b > a) {
        int temp = a;
        a = b;
        b = temp;
    }

    cout << "LCM: " << lcm(a, b) << endl;

    return 0;
    
}

