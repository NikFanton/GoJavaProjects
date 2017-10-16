package real;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class RealPlayer {

    private List<File> tracks = new ArrayList<File>();
    private FileInputStream inputStream;
    private Player player;
    private int indexOfCurrentSong = 0;

    public List<File> getTracks() {
        return tracks;
    }

    public void incIndexOfCurrentSong() {
        indexOfCurrentSong++;
        if (indexOfCurrentSong > tracks.size() - 1) {
            indexOfCurrentSong = 0;
        }
    }

    public void decIndexOfCurrentSong() {
        indexOfCurrentSong--;
        if (indexOfCurrentSong < 0) {
            indexOfCurrentSong = tracks.size() - 1;
        }
    }

    public RealPlayer(File file) {
        findMP3Files(file);
        this.indexOfCurrentSong = 0;
    }

    private void findMP3Files() {
        File f = new File("D:\\download");
        findMP3Files(f);
    }

    private void findMP3Files(File root) {
        for (File file: root.listFiles()) {
            if (file.isFile()) {
                String format = file.getName().substring(file.getName().length()-4, file.getName().length());
                if (format.equals(".mp3")) {
//                    System.out.println(file.getName());
                    tracks.add(file);
                }
            } else {
                findMP3Files(file);
            }
        }
    }

    public void playSong() {
        try {
            inputStream = new FileInputStream(tracks.get(indexOfCurrentSong));
            try {
                player = new Player(inputStream);
                player.play();
            } catch (JavaLayerException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void stopSong() {
        try {
            inputStream = new FileInputStream(tracks.get(indexOfCurrentSong));
            try {
                player = new Player(inputStream);
                player.close();
            } catch (JavaLayerException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void nextSong() {
        stopSong();
        incIndexOfCurrentSong();
        playSong();
    }

    public void previousSong() {
        stopSong();
        decIndexOfCurrentSong();
        playSong();
    }

    public static void main(String[] args) {
        RealPlayer realPlayer = new RealPlayer(new File("D:\\download"));
        File file = new File("D:\\Projects\\GoJavaProjects\\5_2-Inhritance\\src\\resources\\Imagine Dragons \u2013 Believer.mp3");
        realPlayer.findMP3Files();
        System.out.println();
        int i = 1;
        for (File f : realPlayer.tracks) {
            System.out.println(i + " - " + f.getName());
            i++;
        }


    }
}
