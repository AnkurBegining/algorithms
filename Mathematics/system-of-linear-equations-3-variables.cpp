
/*
 * Solve system of linear equation with three variables
 */

#include <iostream>
using namespace std;

int main() {

    double a, b, c, d, e, f, g, h, I, j, k, l, x, y, z;

    cout << "Enter your first equation (ax + by + cz = d)" << endl;
    cout << "a = " ; cin >> a;
    cout << "b = " ; cin >> b;
    cout << "c = " ; cin >> c;
    cout << "d = " ; cin >> d;
    
    cout << "Enter your second equation (ex + fy + gz = h)" << endl;
    cout << "e = " ; cin >> e;
    cout << "f = " ; cin >> f;
    cout << "g = " ; cin >> g;
    cout << "h = " ; cin >> h;
    
    cout << "Enter your third equation (ix + jy + kz = l)" << endl;
    cout << "i = " ; cin >> i;
    cout << "j = " ; cin >> j;
    cout << "k = " ; cin >> k;
    cout << "l = " ; cin >> l;

    z = (I * h * (e * b - a * f) - e * l * (e * b - a * f) - e * d * (I * f - e * j) + a * h * (I * f - e * j)) / ((a * g - e * c) * (I * f - e * j) + (I * g - e * k) * (e * b - a * f));
    y = (e * d - a * h - z * (e * c - a * g)) / (e * b - a * f);
    x = (d - c * z - b * y) / a;

    cout << "x = " << x << endl;
    cout << "y = " << y << endl;
    cout << "z = " << z << endl;

    return 0;

}
