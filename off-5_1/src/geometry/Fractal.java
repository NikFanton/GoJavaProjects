package geometry;

import javafx.scene.layout.Pane;

public class Fractal {
    private int depth;
    private float percentOffset;
    private Triangle triangle;

    public Fractal(int depth, float percentOffset, Triangle triangle) {
        this.depth = depth;
        this.percentOffset = percentOffset;
        this.triangle = triangle;
    }

    private void draw(Pane root, int currentDepth, Triangle triangle) {
        if (currentDepth == depth) {
            return;
        }
        System.out.println(currentDepth);
        triangle.draw(root);
        draw(root, currentDepth + 1, new Triangle(triangle.l1.getPointOnLine(percentOffset),
                triangle.l2.getPointOnLine(percentOffset),
                triangle.l3.getPointOnLine(percentOffset)));
    }

    public void draw(Pane root) {
        draw(root, 0, triangle);
    }
}
