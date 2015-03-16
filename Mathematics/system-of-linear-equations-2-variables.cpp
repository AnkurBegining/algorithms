
/*
 * Solving system of linear equation with 2 variables
 */

#include <iostream>
using namespace std;
int main() {
    
    double a, b, c, d, e, f, x, y;
    
    cout << "Enter your first equation (ax + by = c)" << endl;
    cout << "a = " ; cin >> a;
    cout << "b = " ; cin >> b; 
    cout << "c = " ; cin >> c;

    cout << "Enter your second equation (dx + ey = f)" << endl;
    cout << "d = " ; cin >> d;
    cout << "e = " ; cin >> e;
    cout << "f = " ; cin >> f;

    y = (a * f - d * c) / (-d * b + a * e);
    x = (c - b * y) / a;

    cout << "x: " << x << endl;
    cout << "y: " << y << endl;
    
    return 0;
}

