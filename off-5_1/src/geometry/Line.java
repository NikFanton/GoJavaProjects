package geometry;

import javafx.scene.layout.Pane;

public class Line {
    private Point p1, p2;
    private javafx.scene.shape.Line lineFx;

    public javafx.scene.shape.Line getLineFx() {
        return lineFx;
    }

    public Line(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
        lineFx = new javafx.scene.shape.Line(p1.getX(), p1.getY(), p2.getX(), p2.getY());
    }

    public double calcLength() {
        return p1.calcLength(p2);
    }

    public Point getPointOnLine(float percent) {
        Point point = new Point(p2.getX() - p1.getX(), p2.getY() - p1.getY());
        Line tmpLine = new Line(Point.ZERO, point);
        point.setX(point.getX() * percent + p1.getX());
        point.setY(point.getY() * percent + p1.getY());
        return point;
    }

    public static void main(String[] args) {
        Line line = new Line(new Point(2, 1), new Point(5, 5));
        Point point = line.getPointOnLine(0.25f);
        System.out.println("x = " + point.getX() + " y = " + point.getY());
    }

    public void draw(Pane root) {
        root.getChildren().addAll(lineFx);
    }

    public void clear(Pane root) {
        root.getChildren().remove(lineFx);
    }
}
