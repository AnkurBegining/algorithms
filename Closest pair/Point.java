import java.lang.Math;

public class Point {
    private double x, y;

    public Point() {
        x = 0.0;
        y = 0.0;
    }

    public Point(double x, double y) {
        setX(x);
        setY(y);
    }   

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double distance(Point p) {
        return Math.sqrt(Math.pow(x-p.x, 2) + Math.pow(y-p.y, 2));
    }

    public boolean xEquals(Point p) {
        return (x == p.x);
    }

    public boolean yEquals(Point p) {
        return (y == p.y);
    }

    public String toString() {
        return "x: " + x + "\ty: " + y + "\n";
    }
}
