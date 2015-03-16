/*
 * Find all divisors of an integer
 */

#include <iostream>
using namespace std;

void get_divisors(int n) {
    for (int i = 1; i <= n; i++)
        if (n%i == 0)
            cout << i << " ";
}

int main() {

    int n;
    cout << "Enter an integer: "; cin >> n;

    get_divisors(n);
    cout << endl;

}
