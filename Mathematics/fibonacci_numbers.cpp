
/*
 * Fibonacci sequence
 */

#include <iostream>
using namespace std;

void fibonacci(int n) {

    int first = 0;
    int second = 1;
    cout << first << " ";
    
    for (int i = 0; i < n-1; i++) {
        int temp = second;
        second += first;
        first = temp;
        cout << first << " ";
    }

    cout << endl;

}

int main() {
    int n;
    cout << "How many Fibonacci numbers would you like to see? "; cin >> n;
    fibonacci(n);
    return 0;
}
