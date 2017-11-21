import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class TextEditor extends Application {

    private static final double WINDOW_HEIGHT = 580;
    private static final double WINDOW_WIDTH = 600;
    private String pathToTheFile = "";
    private ArrayList<BigInteger> fibonacciSequence= new ArrayList<>();
    private ExecutorService pool = Executors.newFixedThreadPool(2);

    private void initElements(Pane root) {
        Button btnLoad, btnSave;

        TextField path = new TextField();
        path.setTranslateX(10);
        path.setTranslateY(10);
        path.setMinWidth(WINDOW_WIDTH - 220);
        pathToTheFile = "C:\\Users\\ASUS\\Desktop\\Test.txt";
        path.setText(pathToTheFile);

        TextField userNumber = new TextField();
        userNumber.setTranslateX(10);
        userNumber.setTranslateY(55);
        userNumber.setMinWidth(100);

        TextArea textArea = new TextArea();
        textArea.setTranslateX(10);
        textArea.setTranslateY(95);
        textArea.setPrefWidth(WINDOW_WIDTH - 38);
        textArea.setPrefHeight(420);

        btnLoad = new Button("Load");
        btnLoad.setTranslateX(WINDOW_WIDTH - 200);
        btnLoad.setTranslateY(10);
        btnLoad.setMinWidth(80);
        btnLoad.setOnAction((event) -> {
            try {
                pathToTheFile = path.getText();
                textArea.setText(new Scanner(new File(pathToTheFile)).useDelimiter("\\Z").next());
            } catch (FileNotFoundException e) {
                System.out.println("File not found");
//                e.printStackTrace();
            } catch (NoSuchElementException e) {
                System.out.println("File is empty");
            }
        });

        btnSave = new Button("Save");
        btnSave.setTranslateX(WINDOW_WIDTH - 110);
        btnSave.setTranslateY(10);
        btnSave.setMinWidth(80);
        btnSave.setOnAction(event -> {
            try {
                FileWriter writer = new FileWriter(pathToTheFile);
                writer.write(textArea.getText());
                writer.flush();
            } catch (IOException e) {
                System.out.println("File not found");
//                e.printStackTrace();
            }
        });

        Button btnFibonacci = new Button("Fibonacci");
        btnFibonacci.setTranslateX(205);
        btnFibonacci.setTranslateY(55);
        btnFibonacci.setMinWidth(60);
        btnFibonacci.setOnAction((event) -> {
            FutureTask<ArrayList<BigInteger>> fibonacciCalc = new FutureTask<>(() -> {
                int number = Integer.parseInt(userNumber.getText());
                ArrayList<BigInteger> result = new ArrayList<>();
                if (number == 1) {
                    result.add(BigInteger.valueOf(1));
                } else if (number == 2) {
                    result.add(BigInteger.valueOf(1));
                    result.add(BigInteger.valueOf(1));
                } else if (number > 2){
//                    result.add(BigInteger.valueOf(0));
                    result.add(BigInteger.valueOf(1));
                    BigInteger ans = new BigInteger(String.valueOf(0));
                    BigInteger n1 = new BigInteger(String.valueOf(0));
                    BigInteger n2 = new BigInteger(String.valueOf(1));
                    for (number--; number > 0; number--) {
                        ans = n1.add(n2);
                        n1 = n2;
                        n2 = ans;
                        result.add(ans);
                    }
                }
                String fibonacciStr = fibonacciSequence.toString();

                Platform.runLater(() -> {
                    fibonacciSequence = result;
                    textArea.setText(fibonacciStr);
                });
                return result;
            });
            pool.execute(fibonacciCalc);
        });

        Button btnCancel = new Button("Cancel");
        btnCancel.setTranslateX(295);
        btnCancel.setTranslateY(55);
        btnCancel.setMinWidth(60);
        btnCancel.setOnAction((event) -> {

        });

        root.getChildren().addAll(btnLoad, btnSave, btnFibonacci, btnCancel, path, textArea, userNumber);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setHeight(WINDOW_HEIGHT);
        primaryStage.setWidth(WINDOW_WIDTH);
        primaryStage.setTitle("Text Editor");
        Pane root = new Pane();
        initElements(root);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                Platform.exit();
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
