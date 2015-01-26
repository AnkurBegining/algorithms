public class Pair {
    private Point p1, p2;
    private double distance;

    public Pair() {
        p1 = new Point();
        p2 = new Point();
        distance = 0;
    }

    public Pair(Point p1, Point p2) {
        setP1(p1);
        setP2(p2);
        distance();
    }

    public void setP1(Point p1) {
        this.p1 = p1;
    }

    public void setP2(Point p2) {
        this.p2 = p2;
    }

    public Point getP1() {
        return p1;
    }

    public Point getP2() {
        return p2;
    }

    public double getDistance() {
        return distance;
    }

    public void distance() {
        distance = p1.distance(p2);
    }

    public String toString() {
        return "Pair:\n" + p1 + p2 + "\nDistance: " + distance;
    }
}
