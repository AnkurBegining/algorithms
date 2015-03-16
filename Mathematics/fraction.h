
/*
 * Compute fractions
 */

class Fraction {

private:
    int num, den;

public:
    
    //default constructor
    Fraction() {num = 0; den = 1;};

    void set(int n, int d) {num = n; den = d; normalize();}
    int get_n() {return num;}
    int get_d() {return den;}

    Fraction add(Fraction other);
    Fraction sub(Fraction other);
    Fraction mult(Fraction other);
    Fraction div(Fraction other);

private:
    void normalize();
    int gcf(int a, int b);
    int lcm(int a, int b) {
        int n = gcf(a, b);
        return a / n * b;
    }
};

int operations_on_fractions() {
    Fraction f1, f2, f3;
    int num, den;
    char op;
        cout << "Enter numerator: "; cin >> num;
        cout << "Enter denominator: "; cin >> den;
        f1.set(num, den);
        
        cout << "Arithmetic operator: "; cin >> op;

        cout << "Enter other numerator: "; cin >> num;
        cout << "Enter other denominator: "; cin >> den;
        f2.set(num, den);
        
        if (op == '+') {
            f3 = f1.add(f2);
        }

        else if (op == '-') {
            f3 = f1.sub(f2);
        }

        else if (op == '*') {
            f3 = f1.mult(f2);
        }

        else if (op == '/') {
            f3 = f1.div(f2);
        }

        else {
            cout << op << " is not an arithmetic operator" << endl;
        }
        cout << endl << f3.get_n() << " / " << f3.get_d() << endl << endl;
    }
}

void Fraction::normalize() {
    //Handle cases involving 0
    if (num == 0 || den == 0) {
        num = 0;
        den = 1;
    }

    //Put negative sign in numerator only
    if (den < 0) {
        num *= -1;
        den *= -1;
    }
    //Factor out GCF from num and den
    int n = gcf(num, den);
    num /= n;
    den /= n;

}

int Fraction::gcf(int a, int b) {
    if (b == 0)
        return a;
    else
        return gcf(b, a%b);
}

Fraction Fraction::add(Fraction other) {
    Fraction fract;
    int lcd = lcm(den, other.den);
    int quot1 = lcd/den;
    int quot2 = lcd/other.den;
    fract.set(num * quot1 + other.num * quot2, lcd);
    return fract;
}

Fraction Fraction::sub(Fraction other) {
    Fraction fract;
    other.num *= -1;
    fract = add(other);
    return fract;
}

Fraction Fraction::mult(Fraction other) {
    Fraction fract;
    fract.set(num * other.num, den * other.den);
    return fract;   
}

Fraction Fraction::div(Fraction other) {
    Fraction fract;
    int swap = other.num;
    other.num = other.den;
    other.den = swap;
    fract = mult(other);
    return fract;
}
