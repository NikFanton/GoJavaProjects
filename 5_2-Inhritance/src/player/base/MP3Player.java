package player.base;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public abstract class MP3Player {
    private final float price;
    private Button btn;
    private Label lbl;

    protected Label getLbl() {
        return lbl;
    }

    public float getPrice() {
        return price;
    }

    protected Button getBtn() {
        return btn;
    }

    public MP3Player(float price) {
        this.price = price;
    }

    public abstract void playSong();

    public void show(Pane root, double x, double y) {
        btn = new Button("Play");
        btn.setTranslateX(x);
        btn.setTranslateY(y);
        btn.setMinWidth(100);
        lbl = new Label();
        lbl.setTranslateX(x + btn.getMinWidth() + 10);
        lbl.setTranslateY(y + 5);
        root.getChildren().addAll(btn, lbl);
    }
}
