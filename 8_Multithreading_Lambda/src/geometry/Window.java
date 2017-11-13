package geometry;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Random;

public class Window extends Application {
    private final static int MAX_RECT_SIZE = 150;
    private final static int MIN_RECT_SIZE = 50;
    private final static int RECTANGLE_COUNT = 5;
    private ArrayList<MovableRectangle> rectangles = new ArrayList<>();
    Random random = new Random();


    public Scene initMainScene(Pane root, Stage primaryStage) {
        Scene scene = new Scene(root);

        for (int i = 0; i < RECTANGLE_COUNT; i++) {
            MovableRectangle rect = generateRectangle();
            rectangles.add(rect);
        }
        root.getChildren().addAll(rectangles);

        Button btnSingleThread = new Button("Single thread");

        Button btn = new Button("Start");
        btn.setTranslateX(400);
        btn.setTranslateY(200);
        root.getChildren().add(btn);
        btn.setOnAction(event -> {
            System.out.println(root.getWidth() + ", " + root.getHeight());
            btn.setVisible(false);
            btnSingleThread.setVisible(false);
            for (MovableRectangle rectangle : rectangles) {
                final MovableRectangle tmpRect = rectangle;
                new Thread(() -> {
                    for (int i = 0; i < 10000; i++) {
                        try {
                            Thread.sleep(10);
                            tmpRect.setTranslateX(tmpRect.getTranslateX() + tmpRect.getStepX());
                            tmpRect.setTranslateY(tmpRect.getTranslateY() + tmpRect.getStepY());
                            if (tmpRect.getTranslateX() <= 0 || tmpRect.getTranslateX() >= root.getWidth()) {
                                tmpRect.setStepX(tmpRect.getStepX() * -1);
                                tmpRect.setTranslateX(tmpRect.getTranslateX() + tmpRect.getStepX());
                            }
                            if (tmpRect.getTranslateY() <= 0 || tmpRect.getTranslateY() >= root.getHeight()) {
                                tmpRect.setStepY(tmpRect.getStepY() * -1);
                                tmpRect.setTranslateY(tmpRect.getTranslateY() + tmpRect.getStepY());
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
//                        System.out.println("Thread " + number + ": " + j);
                    }
                }).start();
            }
        });

        btnSingleThread.setTranslateX(373);
        btnSingleThread.setTranslateY(250);
        btnSingleThread.setOnAction(event -> {
            System.out.println(root.getWidth() + ", " + root.getHeight());
            btn.setVisible(false);
            btnSingleThread.setVisible(false);
            new Thread(() -> {
                for (int i = 0; i < 10000; i++) {
                    for (MovableRectangle rectangle : rectangles) {
                        rectangle.setTranslateX(rectangle.getTranslateX() + rectangle.getStepX());
                        rectangle.setTranslateY(rectangle.getTranslateY() + rectangle.getStepY());
                        if (rectangle.getTranslateX() <= 0 || rectangle.getTranslateX() >= 790) {
                            rectangle.setStepX(rectangle.getStepX() * -1);
                            rectangle.setTranslateX(rectangle.getTranslateX() + rectangle.getStepX());
                        }
                        if (rectangle.getTranslateY() <= 0 || rectangle.getTranslateY() >= 395) {
                            rectangle.setStepY(rectangle.getStepY() * -1);
                            rectangle.setTranslateY(rectangle.getTranslateY() + rectangle.getStepY());
                        }
                    }
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(i);
                }
            }).start();
        });
        root.getChildren().add(btnSingleThread);

        return scene;
    }

    public MovableRectangle generateRectangle(){
        MovableRectangle rectangle = new MovableRectangle();
        rectangle.setStepX(random.nextBoolean() ? 1 : -1);
        rectangle.setStepY(random.nextBoolean() ? 1 : -1);
        rectangle.setWidth(random.nextInt(MAX_RECT_SIZE - MIN_RECT_SIZE) + MIN_RECT_SIZE);
        rectangle.setHeight(random.nextInt(MAX_RECT_SIZE - MIN_RECT_SIZE) + MIN_RECT_SIZE);
        rectangle.setTranslateX(random.nextInt(600));
        rectangle.setTranslateY(random.nextInt(300));
        rectangle.setFill(Color.rgb(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
        return rectangle;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Moving geometry");
        primaryStage.setWidth(900);
        primaryStage.setHeight(500);
        Pane root = new Pane();
        System.out.println(primaryStage.getWidth() + " | " + primaryStage.getHeight());
        Scene scene = initMainScene(root, primaryStage);
        primaryStage.setScene(scene);
        System.out.println(scene.getWidth() + ", " + scene.getHeight());
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
