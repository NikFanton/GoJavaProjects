package Start;

import player.derived.*;

public class Main {
    public static void main(String[] args) {
        Player1 player1 = new Player1(2);
        System.out.println("Player 1:");
        player1.playSong();

        Player2 player2 = new Player2(5);
        System.out.println("Player 2:");
        player2.playSong();

        Player3 player3 = new Player3(10);
        System.out.println("Player 3:");
        player3.playSong();
        player3.playAllSongs();

        Player4 player4 = new Player4(12);
        System.out.println("Player 4:");
        player4.playSong();
        player4.playAllSongs();

        Player5 player5 = new Player5(15);
        System.out.println("Player 5:");
        player5.playSong();
        player5.playAllSongs();

        Player6 player6 = new Player6(20);
        System.out.println("Player 6:");
        player6.playSong();
        player6.playAllSongs();
        player6.shuffle();
        player6.playAllSongs();
    }
}
