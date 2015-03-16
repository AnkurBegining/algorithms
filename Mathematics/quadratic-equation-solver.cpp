
/* 
 * Solve quadratic equations ax²+bx+c=0
 * Note: Only compiles with C++0x
 */

#include <iostream>
#include <cmath>
#include <string>
using namespace std;

bool positive_discriminant(double a, double b, double c) {

    return b*b-4*a*c >= 0;

}

void find_roots(double a, double b, double c, string *x, string *y) {

    *x = to_string( (-b + sqrt(b*b-4*a*c)) / (2*a) );
    *y = to_string( (-b - sqrt(b*b -4*a*c)) / (2*a) );
    
}

void find_complex_roots(double a, double b, double c, string *x, string *y) {

    string s1 = "", s2 = "";

    if ( (sqrt(-(pow(b,2) - 4 * a * c)))/(2*a) < 0 )
        s2 = '+';
    else
        s1 = '+';
   
    *x = to_string( -b/(2*a) ) + s1 + to_string( (sqrt(-(pow(b,2)-4*a*c)) ) / (2*a) ) + "i";
    *y = to_string( -b/(2*a) ) + s2 + to_string(-(sqrt(-(pow(b,2)-4*a*c)) ) / (2*a) ) + "i";

}

int main () {

    // equation coeficients
    double a, b, c;
    
    // roots 
    string x, y;

    // get user input
    do { cout << "a = "; cin >> a; } while (a == 0);
    cout << "b = "; cin >> b;
    cout << "c = "; cin >> c;

    // find roots 
    if (positive_discriminant(a, b, c))
        find_roots(a, b, c, &x, &y);
    
    else
        find_complex_roots(a, b, c, &x, &y);

    // print roots
    cout << "x1: " << x << endl;
    cout << "x2: " << y << endl;

    return 0;

}
