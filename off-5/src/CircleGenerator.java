import java.util.Random;

public class CircleGenerator {

    private Circle circle[];

    public CircleGenerator() {
    }

    public void generate(int countOfCircles) {
        Random random = new Random();
        this.circle = new Circle[countOfCircles];
        for (int i = 0; i < countOfCircles; i++) {
            this.circle[i] = new Circle(random.nextFloat() * 10, random.nextFloat() * 100, random.nextFloat()*100);
            System.out.println("x = " + this.circle[i].getPoint().getX() + " y = " + this.circle[i].getPoint().getY() + " r = " + this.circle[i].getRadius());
        }
    }

    public int calcCountOfCollisions() {
        int countOfCollisions = 0;
        for (int i = 0; i < circle.length; i++) {
            for (int j = i + 1; j < circle.length; j++) {
                if (circle[i].collisionCheck(circle[j])) {
                    countOfCollisions++;
                }
            }
        }
        return countOfCollisions;
    }

    public static void main(String[] args) {
        CircleGenerator circleGenerator = new CircleGenerator();
        circleGenerator.generate(10);
        System.out.println("Count of collisions: " + circleGenerator.calcCountOfCollisions());
    }
}
