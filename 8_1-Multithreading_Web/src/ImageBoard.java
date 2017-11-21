import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.*;

public class ImageBoard extends Application{
    private final static double WINDOW_SIZE = 900;
    private final static double INDENT = 10;
    private final static double BOARDER_INDENT = 15;
    private final static int MAX_NUMBER_OF_IMAGES_PER_LINE = 5;
    private final static int NUMBER_OF_LINES = 5;
    private final static double IMAGE_MAX_SIZE = (WINDOW_SIZE - BOARDER_INDENT * 3
            - (MAX_NUMBER_OF_IMAGES_PER_LINE - 1) * INDENT) / MAX_NUMBER_OF_IMAGES_PER_LINE;

    private ExecutorService pool = Executors.newFixedThreadPool(1);
    private ArrayList<URL> urls = new ArrayList<>();
    private ArrayList<ImageView> images = new ArrayList<>();

    private void initURL() throws MalformedURLException {
        urls.add(new URL("https://unsplash.com/photos/N2ZUsECT73U/download?force=true"));
        urls.add(new URL("https://unsplash.com/photos/fjtGI-m-ujc/download?force=true"));
        urls.add(new URL("https://unsplash.com/photos/vnAhvzK315c/download?force=true"));
        urls.add(new URL("https://unsplash.com/photos/jwIk4Z3Msi4/download?force=true"));
        urls.add(new URL("https://unsplash.com/photos/X2gM-SIufpU/download?force=true"));
        urls.add(new URL("https://unsplash.com/photos/3wC1S7IFijI/download?force=true"));
        urls.add(new URL("https://unsplash.com/photos/DaLstmw0r9Y/download?force=true"));
        urls.add(new URL("https://unsplash.com/photos/b1NFkUR-3Fg/download?force=true"));
        urls.add(new URL("https://unsplash.com/photos/Dl6H4_nzBpE/download?force=true"));
        urls.add(new URL("https://unsplash.com/photos/T9CktnMI8TQ/download?force=true"));

        urls.add(new URL("https://unsplash.com/photos/8c6eS43iq1o/download?force=true"));
        urls.add(new URL("https://unsplash.com/photos/l0GRQpXwgPk/download?force=true"));
        urls.add(new URL("https://unsplash.com/photos/3ya_cF-0jzs/download?force=true"));
        urls.add(new URL("https://unsplash.com/photos/zbZQQ1a2WWg/download?force=true"));
        urls.add(new URL("https://unsplash.com/photos/Ae0JXUayWzs/download?force=true"));
        urls.add(new URL("https://unsplash.com/photos/uSFOwYo1qEw/download?force=true"));
        urls.add(new URL("https://unsplash.com/photos/kvbvR0axZ2I/download?force=true"));
        urls.add(new URL("https://unsplash.com/photos/trVNTg3VL5s/download?force=true"));
        urls.add(new URL("https://unsplash.com/photos/MEBqI9fzqao/download?force=true"));
        urls.add(new URL("https://unsplash.com/photos/8V8qCIIo554/download?force=true"));

        urls.add(new URL("https://unsplash.com/photos/UxtIESWxLh8/download?force=true"));
        urls.add(new URL("https://unsplash.com/photos/-Zz9fdo9k94/download?force=true"));
        urls.add(new URL("https://unsplash.com/photos/vrPh1sWmV9E/download?force=true"));
        urls.add(new URL("https://unsplash.com/photos/qr7tsSwDOg0/download?force=true"));
        urls.add(new URL("https://unsplash.com/photos/YSz_PuplTOI/download?force=true"));
        urls.add(new URL("https://unsplash.com/photos/ZwPuquZBnyM/download?force=true"));
        urls.add(new URL("https://unsplash.com/photos/MthLYI2WLCs/download?force=true"));
        urls.add(new URL("https://unsplash.com/photos/KeUKM5N-e_g/download?force=true"));
        urls.add(new URL("https://unsplash.com/photos/cRLEVt6SZxI/download?force=true"));
        urls.add(new URL("https://unsplash.com/photos/7B2v9lFn_m0/download?force=true"));

        urls.add(new URL("https://unsplash.com/photos/OqtafYT5kTw/download?force=true"));
        urls.add(new URL("https://unsplash.com/photos/1iVKwElWrPA/download?force=true"));
        urls.add(new URL("https://unsplash.com/photos/GkraTrCYA_0/download?force=true"));
        urls.add(new URL("https://unsplash.com/photos/sNwnjxm8eTY/download?force=true"));
        urls.add(new URL("https://unsplash.com/photos/hpjSkU2UYSU/download?force=true"));
        urls.add(new URL("https://unsplash.com/photos/yho1aq2aqwc/download?force=true"));
        urls.add(new URL("https://unsplash.com/photos/WHPsxhB4mWQ/download?force=true"));
        urls.add(new URL("https://unsplash.com/photos/AJgFLjnmSs4/download?force=true"));
        urls.add(new URL("https://unsplash.com/photos/G85VuTpw6jg/download?force=true"));
        urls.add(new URL("https://unsplash.com/photos/lK3x9PCj0j4/download?force=true"));

        urls.add(new URL("https://unsplash.com/photos/3whgf7kB3Wg/download?force=true"));
        urls.add(new URL("https://unsplash.com/photos/oG894_zQCZE/download?force=true"));
        urls.add(new URL("https://unsplash.com/photos/9bdt03k4ujw/download?force=true"));
        urls.add(new URL("https://unsplash.com/photos/SV611TeghyI/download?force=true"));
        urls.add(new URL("https://unsplash.com/photos/ouPVsS0cFjk/download?force=true"));
        urls.add(new URL("https://unsplash.com/photos/d3J5oil0ZmE/download?force=true"));
        urls.add(new URL("https://unsplash.com/photos/lylCw4zcA7I/download?force=true"));
        urls.add(new URL("https://unsplash.com/photos/UD1-Kyf_SoM/download?force=true"));
        urls.add(new URL("https://unsplash.com/photos/ixHfyjA49M8/download?force=true"));
        urls.add(new URL("https://unsplash.com/photos/s_2-39udfq0/download?force=true"));
    }

    private void initElements(Pane root) throws MalformedURLException {
        Button refresh = new Button("Refresh");
        refresh.setTranslateX(WINDOW_SIZE - 100);
        refresh.setTranslateY(5);
        refresh.setOnAction((event) -> {
            FutureTask<ArrayList<ImageView>> loadImage = new FutureTask<ArrayList<ImageView>>(() -> {
                ArrayList<ImageView> result = new ArrayList<>();
                Random random = new Random();
                int indexOfRandomImage;
                double xPos = BOARDER_INDENT;
                double yPos = BOARDER_INDENT + 30;
                for (int i = 0; i < 1; i++) {
                    for (int j = 0; j < MAX_NUMBER_OF_IMAGES_PER_LINE; j++) {
                        indexOfRandomImage = random.nextInt(urls.size());
                        ImageView imageView = new ImageView(new Image(urls.get(indexOfRandomImage).openStream()));
                        imageView.setFitHeight(IMAGE_MAX_SIZE);
                        imageView.setFitWidth(IMAGE_MAX_SIZE);
                        imageView.setTranslateX(xPos);
                        imageView.setTranslateY(yPos);
                        xPos += IMAGE_MAX_SIZE + INDENT;
                        result.add(imageView);
                        System.out.println((i * NUMBER_OF_LINES + j) + " - is ready");
                    }
                    xPos = BOARDER_INDENT;
                    yPos += IMAGE_MAX_SIZE + INDENT;
                }
                Platform.runLater(() -> {
                    images = result;
                    root.getChildren().addAll(images);
                });
                return result;
            });

            for (ImageView imageView : images) {
                root.getChildren().remove(imageView);
            }
            pool.execute(loadImage);
//            pool.shutdown();
        });
        root.getChildren().add(refresh);
        initURL();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setHeight(WINDOW_SIZE + 60);
        primaryStage.setWidth(WINDOW_SIZE);
        System.out.println(primaryStage.getHeight());
        System.out.println(primaryStage.getWidth());
        primaryStage.setTitle("Image board");
        Pane root = new Pane();
        initElements(root);
//        generateImageMatrix(root);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
