import com.mashape.unirest.http.HttpResponse;
import entity.YouTubeItem;
import entity.YouTubeResponse;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class YouTubeFrame extends Application {
    private final static int WINDOW_HEIGHT = 900;
    private final static int WINDOW_WIDTH = 1200;
    private final static int VERTICAL_OFFSET = 60;
    private final static int VIDEO_PREVIEW_WIDTH = 320;

    private ExecutorService pool = Executors.newFixedThreadPool(4);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();

        Pane content = new Pane();
        ScrollPane scrollPane = new ScrollPane(content);
        scrollPane.setTranslateX(10);
        scrollPane.setTranslateY(VERTICAL_OFFSET);
        scrollPane.setPannable(true);
        scrollPane.setPrefSize(WINDOW_WIDTH, WINDOW_HEIGHT - VERTICAL_OFFSET);

        // Update scrollPane size properties after window resize
        root.heightProperty().addListener((observable, oldValue, newValue) -> {
            scrollPane.setPrefHeight(newValue.doubleValue() - VERTICAL_OFFSET - 10);
        });

        root.widthProperty().addListener((observable, oldValue, newValue) -> {
            scrollPane.setPrefWidth(newValue.doubleValue() - 20);
        });

        TextField textField = new TextField("Wylsacom");
        textField.setTranslateX(10);
        textField.setTranslateY(10);

        Button btnSendRequest = new Button("Request");
        btnSendRequest.setTranslateX(200);
        btnSendRequest.setTranslateY(10);

        btnSendRequest.setOnMouseClicked(event -> {
            String search = textField.getText();
            pool.submit(() -> {
                HttpResponse<YouTubeResponse> response = YouTubeClient.getSearchResult(search, 5);
                System.out.println("Response code: " + response.getStatus());
                YouTubeResponse body = response.getBody();
                Platform.runLater(() -> {
                    printResult(content, body);
                });
            });
        });

        root.getChildren().addAll(scrollPane, textField, btnSendRequest);

        primaryStage.setTitle("YouTube API");
        primaryStage.setHeight(WINDOW_HEIGHT);
        primaryStage.setWidth(WINDOW_WIDTH);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        primaryStage.setOnCloseRequest(event -> {
            Platform.exit();
            System.exit(0);
        });
    }

    public void printResult(Pane content, YouTubeResponse response) {
        content.getChildren().clear();

        double yOffset = 10.;
        double scale = 1.3;

        for (int i = 0; i < response.items.size(); i++) {
            YouTubeItem item = response.items.get(i);
            System.out.println(item.snippet.thumbnails.medium.width);
            ImageView imageView = new ImageView(new Image(item.snippet.thumbnails.medium.url));
            imageView.setFitHeight(imageView.getImage().getHeight());
            imageView.setFitWidth(imageView.getImage().getWidth());
            imageView.setTranslateX(0);
            imageView.setTranslateY(yOffset);

            Label title = new Label(item.snippet.title);
            title.setTranslateX(scale * VIDEO_PREVIEW_WIDTH);
            title.setTranslateY(yOffset + 10);
            title.setScaleX(scale);
            title.setScaleY(scale);

            Label channelTitle = new Label(item.snippet.channelTitle);
            channelTitle.setTranslateX(VIDEO_PREVIEW_WIDTH + 40);
            channelTitle.setTranslateY(yOffset + 50);

            Label publishedAt = new Label(item.snippet.publishedAt);
            publishedAt.setTranslateX(VIDEO_PREVIEW_WIDTH + 40);
            publishedAt.setTranslateY(yOffset + 90);

            Button btnView = new Button("VIEW");
            btnView.setTranslateX(VIDEO_PREVIEW_WIDTH + 40);
            btnView.setTranslateY(yOffset + 130);
            btnView.setOnMouseClicked(event -> {
                String path = "http://www.sample-videos.com/video/mp4/720/big_buck_bunny_720p_1mb.mp4";
                MediaPlayer player = new MediaPlayer(new Media(path));
                MediaView mediaView = new MediaView(player);
                content.getChildren().add(mediaView);
                player.play();
            });

            yOffset += imageView.getImage().getHeight() + 20;

            content.getChildren().addAll(imageView, title, channelTitle, publishedAt, btnView);
        }
        content.setPrefHeight(yOffset);
    }
}
