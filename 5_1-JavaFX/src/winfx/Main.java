package winfx;

import figures.Snowman;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class Main extends Application {

    public void initViews(Pane root) {
        Snowman snowman = new Snowman(5, 30, 80);
        root.getChildren().addAll(snowman.getCircles());
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Snowman");
        primaryStage.setWidth(500);
        primaryStage.setHeight(800);

        Pane root = new Pane();
        initViews(root);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
