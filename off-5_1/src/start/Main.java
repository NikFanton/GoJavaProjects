package start;

import geometry.Fractal;
import geometry.Line;
import geometry.Point;
import geometry.Triangle;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Geometry");
        primaryStage.setWidth(600);
        primaryStage.setHeight(500);
        Pane root = new Pane();

        Line line = new Line(new Point(70, 30), new Point(100, 300));
        line.draw(root);
        line.clear(root);

        Triangle triangle = new Triangle(new Point(200, 30), new Point(50, 300), new Point(350, 300));
        triangle.draw(root);
        triangle.clear(root);

        Fractal fractal = new Fractal(20, 0.1f, triangle);
        fractal.draw(root);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
