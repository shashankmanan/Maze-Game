import java.awt.*;

import javax.swing.ImageIcon;

public class Player {
    int tileX, tileY;
    Image character;

    Player() {
        character = new ImageIcon("character.png").getImage();

        tileX = 1;
        tileY = 1;
    }

    Image getPlayer() {
        return character;
    }

    int getTileX() {
        return tileX;
    }

    int getTileY() {
        return tileY;
    }

    public void move(int dx, int dy) {
        this.tileX += dx;
        this.tileY += dy;
    }
}
