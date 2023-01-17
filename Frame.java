
import javax.swing.*;
import java.awt.Image;

interface DefaultSize {
    final int screenSizeX = 464;
    final int screenSizeY = 485;
    final Image gameIcon = new ImageIcon("gameIcon.png").getImage();
}

public class Frame extends JPanel implements DefaultSize {
    void setDefault(JFrame jf) {
        jf.setSize(DefaultSize.screenSizeX, DefaultSize.screenSizeY);
        jf.setResizable(false);

        // opens up in the center of the screen
        jf.setLocationRelativeTo(null);
        // terminates the program on close button
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // gameicon in the taskbar and the gameicon
        jf.setIconImage(DefaultSize.gameIcon);
    }
}
