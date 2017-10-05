package winfx;

import figures.Snowman;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;


public class Main extends Application {

    public void initViews(Pane root) {
        Circle[] circles;
        TextField textFieldCircles = new TextField();
        TextField textFieldMinRadius = new TextField();
        TextField textFieldMaxRadius = new TextField();
        Label[] labels = new Label[] {  new Label("Count of circles"),
                                        new Label("Minimal radius"),
                                        new Label("Maximal radius")};
        float distanceX1 = 5;
        float distanceX2 = 115;
        float dDistanceY = 40;
        labels[0].setTranslateX(distanceX1);
        labels[0].setTranslateY(15);
        labels[1].setTranslateX(distanceX1);
        labels[1].setTranslateY(15 + dDistanceY);
        labels[2].setTranslateX(distanceX1);
        labels[2].setTranslateY(15 + (2 * dDistanceY));

        textFieldCircles.setTranslateX(distanceX2);
        textFieldCircles.setTranslateY(10);
        textFieldMinRadius.setTranslateX(distanceX2);
        textFieldMinRadius.setTranslateY(10 + dDistanceY);
        textFieldMaxRadius.setTranslateX(distanceX2);
        textFieldMaxRadius.setTranslateY(10 + (2 * dDistanceY));
        textFieldCircles.setText("5");
        textFieldMinRadius.setText("30");
        textFieldMaxRadius.setText("80");

        Button btnShow = new Button("Show snowman");
        btnShow.setTranslateX(distanceX2);
        btnShow.setTranslateY(10 + (3 * dDistanceY));
        btnShow.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                int circles = Integer.parseInt(textFieldCircles.getText());
                float minRadius = Float.parseFloat(textFieldMinRadius.getText());
                float maxRadius = Float.parseFloat(textFieldMaxRadius.getText());
                Snowman snowman = new Snowman(circles, minRadius, maxRadius);
                root.getChildren().clear();
                root.getChildren().addAll(snowman.getCircles());
            }
        });

        Button btnFillRed = new Button("Show snowman");
        btnFillRed.setTranslateX(10);
        btnFillRed.setTranslateY(root.getHeight() - 20);
        btnFillRed.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

            }
        });

        root.getChildren().addAll(btnShow, textFieldCircles, textFieldMinRadius, textFieldMaxRadius);
        root.getChildren().addAll(labels);



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
