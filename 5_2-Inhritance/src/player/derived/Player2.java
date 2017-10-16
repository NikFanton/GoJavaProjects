package player.derived;

import javafx.scene.layout.Pane;
import player.base.SingleMP3Player;

public class Player2 extends SingleMP3Player {

    public Player2(float price) {
        super(price);
    }

    @Override
    public void playSong() {
        System.out.println("\terror");
    }

    @Override
    public void show(Pane root, double x, double y) {
        super.show(root, x, y);
        getBtn().setOnMouseClicked(event -> getLbl().setText("error"));
    }
}
