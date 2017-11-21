import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class FileViewer extends Application {
    private static final double WINDOW_HEIGHT = 650;
    private static final double WINDOW_WIDTH = 650;
    private static final String CACHE_PATH = "files/cache/";
    private static final String LINKS_PATH = "files/links.txt";
    private HashMap<File, URL> map = new HashMap<>();
    private ExecutorService pool = Executors.newFixedThreadPool(2);


    private void initFiles(String pathToLinks) {
        try {
            Scanner scanner = new Scanner(new File(pathToLinks));
            while (scanner.hasNext()) {
                try {
                    URL url = new URL(scanner.nextLine());
                    String strings[] = String.valueOf(url).split("/");
                    String name = strings[strings.length - 1];
                    File file = new File(CACHE_PATH + name);
                    map.put(file, url);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    private void initElements(Pane root) {
        initFiles(LINKS_PATH);
        double posY = 20.0;
        for (File file : map.keySet()) {
            Label lbl = new Label(file.getName());
            lbl.setTranslateX(20);
            lbl.setTranslateY(posY + 5);
            lbl.setScaleX(1.1);
            lbl.setScaleY(1.1);
            lbl.setMaxWidth(310);

            Button btnShow = new Button("SHOW");
            btnShow.setTranslateX(360);
            btnShow.setTranslateY(posY);
            btnShow.setOnAction(event -> {
                final File f = file;
                FutureTask show = new FutureTask(() -> {
                    try {
                        ReadableByteChannel rbc = Channels.newChannel(map.get(f).openStream());
                        FileOutputStream fos = new FileOutputStream(CACHE_PATH + f.getName());
                        fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
                        System.out.println(f.getName() + " - cashed");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return null;
                });
                if (!f.exists()) {
                    pool.execute(show);
                } else {
                    System.out.println(f.getName() + " - exist");
                }
            });

            Button btnHide = new Button("HIDE");
            btnHide.setTranslateX(440);
            btnHide.setTranslateY(posY);

            ProgressBar progressBar = new ProgressBar();
            progressBar.setTranslateX(520);
            progressBar.setTranslateY(posY);
            posY += 40.;


            root.getChildren().addAll(lbl, btnShow, btnHide, progressBar);
        }

//        File Chooser
//
//        filesButton.setOnAction((ActionEvent e) -> {
//            FileChooser fc = new FileChooser();
//            fc.getExtensionFilters().add(new ExtensionFilter("*.flv", "*.mp4", "*.mpeg"));
//            File file = fc.showOpenDialog(null);
//            String path = file.getAbsolutePath();
//            path = path.replace("\\", "/");
//            media = new Media(new File(path).toURI().toString());
//            mediaPlayer.stop();
//            mediaPlayer = new MediaPlayer(media);
//            mediaPlayer.setAutoPlay(true);
//            mediaView.setMediaPlayer(mediaPlayer);
//        });
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setHeight(WINDOW_HEIGHT);
        primaryStage.setWidth(WINDOW_WIDTH);
        primaryStage.setTitle("File Viewer");
        Pane root = new Pane();

        Media pick = new Media("crowd-cheering.mp3");
        MediaPlayer player = new MediaPlayer(pick);
        player.play();

        MediaView mediaView = new MediaView(player);
        root.getChildren().addAll(mediaView);

        initElements(root);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        primaryStage.setOnCloseRequest( (event) -> {
            Platform.exit();
            System.exit(0);
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
