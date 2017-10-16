package Start;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import player.base.MP3Player;
import player.derived.*;

public class Main extends Application {


    public static void initPlayers(Pane root) {
        Player1 player1 = new Player1(2);
        System.out.println("Player 1:");
        player1.playSong();
        player1.show(root, 10, 30);

        Player2 player2 = new Player2(5);
        System.out.println("Player 2:");
        player2.playSong();
        player2.show(root, 10, 150);

        Player3 player3 = new Player3(10);
        System.out.println("Player 3:");
        player3.playSong();
        player3.playAllSongs();
        player3.show(root, 250, 30);

        Player4 player4 = new Player4(12);
        System.out.println("Player 4:");
        player4.playSong();
        player4.playAllSongs();
        player4.show(root, 510, 30);

        Player5 player5 = new Player5(15);
        System.out.println("Player 5:");
        player5.playSong();
        player5.playAllSongs();
        player5.show(root, 250, 150);

        Player6 player6 = new Player6(20);
        System.out.println("Player 6:");
        player6.playSong();
        player6.playAllSongs();
        player6.shuffle();
        player6.playAllSongs();
        player6.show(root, 510, 150);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("MP3-Player");
        primaryStage.setWidth(900);
        primaryStage.setHeight(500);
        Pane root = new Pane();

        initPlayers(root);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
