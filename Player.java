import java.awt.Image;
import javax.swing.ImageIcon;

//player class used to represent main character
public class Player {
    // coordinates of player
    int playerX, PlayerY;
    final Image character = new ImageIcon("character.png").getImage();

    Player() {
        playerX = 1;
        PlayerY = 1;
    }

    // move method
    public void move(int distanceTravelledX, int distanceTravelledY) {
        this.playerX += distanceTravelledX; // add distance traveled to original distance
        this.PlayerY += distanceTravelledY;
    }
}
