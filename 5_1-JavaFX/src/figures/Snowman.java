package figures;

import javafx.scene.paint.Color;

import javafx.scene.shape.Circle;

import java.util.Random;

public class Snowman {

    /**
     * n = size-1;
     * circles[0..n-3]   - body-circles
     * circles[n-2..n-1] - eye circles
     * circles[n]        - nose-circle
     */
    Circle[] circles;

    public Circle[] getCircles() {
        return circles;
    }

    public Snowman(Circle[] circles) {
        this.circles = circles;
    }

    public Snowman(int size, double minRadius, double maxRadius, double winWidth, double winHeight) {
        size += 3;
        circles = new Circle[size];

        Random random = new Random();
        double distanceX = winWidth / 2;
        double distanceY = winHeight;
        double radius = 0.;
        for (int i = size - 4; i >= 0; i--) {
            radius = random.nextDouble() * (maxRadius - minRadius) + minRadius;
            circles[i] = new Circle(radius);
            circles[i].setCenterY(distanceY - radius);
            circles[i].setCenterX(distanceX);
            circles[i].setStrokeWidth(2);
            distanceY -= 2 * radius;
        }
        circles[size - 3] = new Circle(random.nextFloat() * ((1. - Math.sqrt(2) / 2.) * circles[0].getRadius()));
        circles[size - 3].setCenterX(distanceX - circles[0].getRadius() / 2);
        circles[size - 3].setCenterY(distanceY + circles[0].getRadius() / 2);
        circles[size - 2] = new Circle(random.nextFloat() * ((1. - Math.sqrt(2) / 2.) * circles[0].getRadius()));
        circles[size - 2].setCenterX(distanceX + circles[0].getRadius() / 2);
        circles[size - 2].setCenterY(distanceY + circles[0].getRadius() / 2);
        circles[size - 1] = new Circle(random.nextFloat() * (Math.sqrt(2) - 1) * circles[0].getRadius());
        circles[size - 1].setCenterX(distanceX);
        circles[size - 1].setCenterY(distanceY + circles[0].getRadius());

        int r, g, b;

        for (int i = 0; i < size; i++) {
            r = random.nextInt(255);
            g = random.nextInt(255);
            b = random.nextInt(255);
            circles[i].setFill(Color.WHITE);
            circles[i].setStroke(Color.rgb(r, g, b, 1));
        }
    }

    public static void main(String[] args) {
        Snowman snowman = new Snowman(5, 20, 100, 500, 800);
    }

}
