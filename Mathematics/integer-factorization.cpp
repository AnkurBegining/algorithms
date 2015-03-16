
/*
 * Integer factorization
 */

#include <iostream>
#include <cmath>
using namespace std;

void integer_factorization(int n) {
    
    int square = sqrt(n);
    for (int i = 2; i <= square; i++)
        if (n%i == 0) {
            cout << i << " ";
            n /= i;
            square = sqrt(n);
        }

    cout << n << " ";

}

int main() {

    int n;
    cout << "Enter number: "; cin >> n;
    
    integer_factorization(n);
    cout << endl;
    return 0;
    
}
