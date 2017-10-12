package geometry;

public class Point {
    private double x;
    private double y;
    public static final Point ZERO = new Point(0, 0);

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double calcLength(Point otherPoint) {
        return Math.sqrt((this.x - otherPoint.getX())*(this.x - otherPoint.getX()) +
                (this.y - otherPoint.getY())*(this.y - otherPoint.getY()));
    }

    public double calcLength() {
        return calcLength(ZERO);
    }

    public Point normalize() {
        double length = calcLength();
        return new Point(this.x / length, this.y / length);
    }

    public static void main(String[] args) {
        Point point1 = new Point(2, 1);
        Point point2 = new Point(5, 5);
        Point normal = point1.normalize();

        System.out.println("Length: " + point1.calcLength(point2));
        System.out.println("Vector length: " + point1.calcLength());
        System.out.println("Normal vector: x = " + normal.getX() + " y = " + normal.getY() + " Length = " +
                normal.calcLength());
    }
}
