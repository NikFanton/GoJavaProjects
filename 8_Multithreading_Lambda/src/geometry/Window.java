package geometry;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Random;

public class Window extends Application {
    private final static int MAX_RECT_SIZE = 150;
    private final static int MIN_RECT_SIZE = 50;
    private final static int RECTANGLE_COUNT = 1;
    private ArrayList<Rectangle> rectangles;

    public Window() {
    }

    public Scene initMainScene(Pane root) {
        Scene scene = new Scene(root);
        rectangles = new ArrayList<>();
        Random random = new Random();
        int r, g, b;
        int posX, posY, x, y;

        for (int i = 0; i < RECTANGLE_COUNT; i++) {
            r = random.nextInt(255);
            g = random.nextInt(255);
            b = random.nextInt(255);
            x = random.nextInt(MAX_RECT_SIZE - MIN_RECT_SIZE) + MIN_RECT_SIZE;
            y = random.nextInt(MAX_RECT_SIZE - MIN_RECT_SIZE) + MIN_RECT_SIZE;
            posX = random.nextInt(600);
            posY = random.nextInt(300);

            Rectangle rect = new Rectangle(x, y, Color.rgb(r, g, b));
            rect.setTranslateX(posX);
            rect.setTranslateY(posY);
            rectangles.add(rect);
        }
        root.getChildren().addAll(rectangles);

        Button btn = new Button("Start");
        btn.setTranslateX(400);
        btn.setTranslateY(200);
        root.getChildren().add(btn);
        btn.setOnAction(event -> {
            System.out.println(root.getWidth() + ", " + root.getHeight());
            btn.setVisible(false);
            for (Rectangle rectangle : rectangles) {
                final Rectangle tmpRect = rectangle;
                new Thread(() -> {
                    int newX = (int) tmpRect.getTranslateX();
                    int newY = (int) tmpRect.getY();
                    int durationX = random.nextInt(2);
                    int durationY = random.nextInt(2);
                    int stepX = (durationX == 1 ? 1 : -1);
                    int stepY = (durationY == 1 ? 1 : -1);
                    boolean changeDirection = true;
                    for (int i = 0; i < 1000; i++) {
                        try {
                            Thread.sleep(10);
                            tmpRect.setTranslateX(tmpRect.getTranslateX() + stepX);
                            tmpRect.setTranslateY(tmpRect.getTranslateY() + stepY);
                            if (tmpRect.getTranslateX() <= 0 || tmpRect.getTranslateX() >= 790) {
                                stepX *= -1; tmpRect.setTranslateX(tmpRect.getTranslateX() + stepX);
                            }
                            if (tmpRect.getTranslateY() <= 0 || tmpRect.getTranslateY() >= 395) {
                                stepY *= -1; tmpRect.setTranslateY(tmpRect.getTranslateY() + stepY);
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
//                        System.out.println("Thread " + number + ": " + j);
                    }
                }).start();
            }
        });

        Button btnSingleThread = new Button("Single thread");
        btnSingleThread.setTranslateX(373);
        btnSingleThread.setTranslateY(250);
        root.getChildren().add(btnSingleThread);

        return scene;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Moving geometry");
        primaryStage.setWidth(900);
        primaryStage.setHeight(500);
        Pane root = new Pane();
        System.out.println(primaryStage.getWidth() + " | " + primaryStage.getHeight());
        Scene scene = initMainScene(root);
        primaryStage.setScene(scene);
        System.out.println(scene.getWidth() + ", " + scene.getHeight());
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
