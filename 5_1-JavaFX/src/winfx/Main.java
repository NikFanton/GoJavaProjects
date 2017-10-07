package winfx;

import figures.Snowman;
import figures.Star;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {
    private Scene menu;
    private Snowman snowman;

    private void initSnowmanViews(Stage primaryStage, Pane root) {
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

        Button btnFillRed = new Button("Fill red");
        btnFillRed.setTranslateX(10);
        btnFillRed.setTranslateY(15);
        btnFillRed.setMinWidth(100);

        Button btnGradient = new Button("Gradient");
        btnGradient.setTranslateX(120);
        btnGradient.setTranslateY(15);
        btnGradient.setMinWidth(100);

        Button btnBack = new Button("Back");
        btnBack.setTranslateX(400);
        btnBack.setTranslateY(10);

        btnShow.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                int circles = Integer.parseInt(textFieldCircles.getText());
                float minRadius = Float.parseFloat(textFieldMinRadius.getText());
                float maxRadius = Float.parseFloat(textFieldMaxRadius.getText());
                snowman = new Snowman(circles, minRadius, maxRadius, root.getWidth(), root.getHeight());
                root.getChildren().clear();
                root.getChildren().addAll(snowman.getCircles());
                root.getChildren().addAll(btnFillRed, btnGradient, btnBack);
            }
        });

        btnFillRed.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                for (int i = 0; i < snowman.getCircles().length - 3; i++) {
                    snowman.getCircles()[i].setFill(Color.RED);
                    snowman.getCircles()[i].setStroke(Color.BLACK);
                }
                for (int i = snowman.getCircles().length - 3; i < snowman.getCircles().length; i++) {
                    snowman.getCircles()[i].setFill(Color.BLACK);
                    snowman.getCircles()[i].setStroke(Color.BLACK);
                }
            }
        });

        btnGradient.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                double opacity = 0.5/(snowman.getCircles().length - 3);
                for (int i = 0; i < snowman.getCircles().length - 3; i++) {
                    snowman.getCircles()[i].setFill(Color.rgb(0, 0, 0, opacity * (i + 1)));
                    snowman.getCircles()[i].setStroke(Color.rgb(0, 0, 0, 1));
                }
                for (int i = snowman.getCircles().length - 3; i < snowman.getCircles().length; i++) {
                    snowman.getCircles()[i].setFill(Color.BLACK);
                    snowman.getCircles()[i].setStroke(Color.BLACK);
                }
            }
        });

        btnBack.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                root.getChildren().clear();
                root.getChildren().addAll(textFieldCircles, textFieldMinRadius, textFieldMaxRadius, btnShow, btnBack);
                root.getChildren().addAll(labels);
                primaryStage.setScene(menu);
            }
        });

        root.getChildren().addAll(btnShow, btnBack, textFieldCircles, textFieldMinRadius, textFieldMaxRadius);
        root.getChildren().addAll(labels);

    }

    private void initStarViews(Stage primaryStage, Pane root) {
        TextField textFieldPosX = new TextField();
        TextField textFieldPosY = new TextField();
        TextField textFieldRadius = new TextField();
        Label[] labels = new Label[] {  new Label("Center X"),
                                        new Label("Center Y"),
                                        new Label("Radius")};
        float distanceX1 = 5;
        float distanceX2 = 115;
        float dDistanceY = 40;
        labels[0].setTranslateX(distanceX1);
        labels[0].setTranslateY(15);
        labels[1].setTranslateX(distanceX1);
        labels[1].setTranslateY(15 + dDistanceY);
        labels[2].setTranslateX(distanceX1);
        labels[2].setTranslateY(15 + (2 * dDistanceY));

        textFieldPosX.setTranslateX(distanceX2);
        textFieldPosX.setTranslateY(10);
        textFieldPosY.setTranslateX(distanceX2);
        textFieldPosY.setTranslateY(10 + dDistanceY);
        textFieldRadius.setTranslateX(distanceX2);
        textFieldRadius.setTranslateY(10 + (2 * dDistanceY));
        textFieldPosX.setText("200");
        textFieldPosY.setText("250");
        textFieldRadius.setText("80");

        Button btnShow = new Button("Show star");
        btnShow.setTranslateX(distanceX2);
        btnShow.setTranslateY(10 + (3 * dDistanceY));

        Button btnBack = new Button("Back");
        btnBack.setTranslateX(400);
        btnBack.setTranslateY(10);

        btnBack.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                root.getChildren().clear();
                root.getChildren().addAll(textFieldPosX, textFieldPosY, textFieldRadius, btnShow, btnBack);
                root.getChildren().addAll(labels);
                primaryStage.setScene(menu);
            }
        });

        btnShow.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Star star = new Star(   Double.parseDouble(textFieldRadius.getText()),
                                        Double.parseDouble(textFieldPosX.getText()),
                                        Double.parseDouble(textFieldPosY.getText()) );
                root.getChildren().clear();
                root.getChildren().addAll(star.getStar());
                root.getChildren().addAll(btnBack);
            }
        });
        root.getChildren().addAll(textFieldPosX, textFieldPosY, textFieldRadius, btnShow, btnBack);
        root.getChildren().addAll(labels);
    }

    private Scene initSnowmanScene(Stage primaryStage) {
        Pane root = new Pane();
        initSnowmanViews(primaryStage, root);
        return new Scene(root);
    }

    private Scene initStarScene(Stage primaryStage) {
        Pane root = new Pane();
        initStarViews(primaryStage, root);
        return new Scene(root);
    }

    private Scene initMenuScene(Stage primaryStage, Scene scene1, Scene scene2) {
        Pane root = new Pane();
        float distanceX = 175;
        Label lblTitle = new Label("FIGURES");
        lblTitle.setMinWidth(100);
        lblTitle.setAlignment(Pos.CENTER);
        lblTitle.setTranslateX(distanceX);
        lblTitle.setTranslateY(20);
        Button btnSnowman = new Button("Snowman");
        Button btnStar = new Button("Star");
        Button btnExit = new Button("Exit");
        btnSnowman.setTranslateX(distanceX);
        btnSnowman.setTranslateY(50);
        btnSnowman.setMinWidth(100);
        btnStar.setTranslateX(distanceX);
        btnStar.setTranslateY(90);
        btnStar.setMinWidth(100);
        btnExit.setTranslateX(distanceX);
        btnExit.setTranslateY(130);
        btnExit.setMinWidth(100);

        btnSnowman.setOnMouseClicked(event -> primaryStage.setScene(scene1));
        btnStar.setOnMouseClicked(event -> primaryStage.setScene(scene2));
        btnExit.setOnMouseClicked(event -> primaryStage.close());
        root.getChildren().addAll(lblTitle, btnSnowman, btnStar, btnExit);
        return new Scene(root);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("JavaFX");
        primaryStage.setWidth(500);
        primaryStage.setHeight(800);
        Scene scene1 = initSnowmanScene(primaryStage);
        Scene scene2 = initStarScene(primaryStage);
        menu = initMenuScene(primaryStage, scene1, scene2);
        menu.getRoot();
        primaryStage.setScene(menu);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
