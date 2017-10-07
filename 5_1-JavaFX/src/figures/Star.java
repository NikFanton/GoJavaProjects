package figures;

import javafx.scene.shape.Line;

public class Star {

    private Line lines[] = new Line[10];

    public Line[] getStar() {
        return lines;
    }

    public Star(double radius, double centerX, double centerY) {
        final double smallRadius = 5*radius/13;
        double angle = -Math.PI / 10;
        for (int i = 0; i < lines.length - 1; i += 2) {
            lines[i] = new Line();
            lines[i].setStartX(radius * Math.cos(angle) + centerX);
            lines[i].setStartY(radius * Math.sin(angle) + centerY);
            angle += Math.PI / 5;
            lines[i].setEndX(smallRadius * Math.cos(angle) + centerX);
            lines[i].setEndY(smallRadius * Math.sin(angle) + centerY);
            lines[i+1] = new Line();
            lines[i+1].setStartX(smallRadius * Math.cos(angle) + centerX);
            lines[i+1].setStartY(smallRadius * Math.sin(angle) + centerY);
            angle += Math.PI / 5;
            lines[i+1].setEndX(radius * Math.cos(angle) + centerX);
            lines[i+1].setEndY(radius * Math.sin(angle) + centerY);
        }

    }

    public static void main(String[] args) {
        Star star = new Star(10, 500, 800);
    }
}
