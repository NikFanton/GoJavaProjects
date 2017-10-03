
public class Circle {

    private float radius;
    private Point point;

    public float getRadius() {
        return radius;
    }

    public Point getPoint() {
        return point;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public Circle() {
        this.radius = 0;
        this.point = new Point();
    }

    public Circle(float radius) {
        this.radius = radius;
        this.point = new Point();
    }

    public Circle(float radius, float x, float y) {
        this.radius = radius;
        this.point = new Point(x, y);
    }

    public Circle(float radius, Point point) {
        this.radius = radius;
        this.point = new Point(point.getX(), point.getY());
    }

    public boolean collisionCheck(Circle otherCircle) {
        if ((this.radius + otherCircle.radius) >= this.point.calcLength(otherCircle.getPoint())) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Circle circle1 = new Circle(5);
        Circle circle2 = new Circle(2, 7, 0);
        Circle circle3 = new Circle(2, 7.1f, 0);
        System.out.println("circle 1 /\\ circle 2 = " + circle1.collisionCheck(circle2));
        System.out.println("circle 1 /\\ circle 3 = " + circle1.collisionCheck(circle3));
    }
}
