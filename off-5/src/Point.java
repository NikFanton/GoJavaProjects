
public class Point {
    private float x;
    private float y;

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public Point() {
        this.x = 0.0f;
        this.y = 0.0f;
    }

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float calcLength(Point otherPoint) {
        return (float)Math.sqrt((this.x - otherPoint.x)*(this.x - otherPoint.x) +
                (this.y - otherPoint.y)*(this.y - otherPoint.y));
    }

    public static void main(String[] args) {
        Point p1 = new Point(0, 3);
        Point p2 = new Point(4, 0);
        System.out.println("Length: " + p1.calcLength(p2));
    }
}
