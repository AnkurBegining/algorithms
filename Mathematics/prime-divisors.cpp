#include <iostream>
#include <cmath>

int main() {

    int n;
    std::cin >> n;
    
    for (int i = 2; i <= n; i++) {
         if (n % i == 0) {
             n /= i;
             std::cout << i << ((n != 1) ? ", " : ""); 
             i = 1;
         }
    }

    std::cout << std::endl;

    return 0;
}
