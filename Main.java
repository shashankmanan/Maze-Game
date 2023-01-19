import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

//Main class 
public class Main extends Frame {
    JFrame mainFrame;

    Main(int level) {
        if (level < 4) {
            mainFrame = new JFrame();
            mainFrame.setVisible(true);
            this.setDefault(mainFrame);
            mainFrame.add(new Board(level));

        } else {
            // end screen
            mainFrame = new JFrame();
            mainFrame.setVisible(true);
            this.setDefault(mainFrame);
            mainFrame.getContentPane().setBackground(Color.BLACK);

            mainFrame.add(new JLabel(new ImageIcon("endscreen.png")));

        }
    }

    // calls intro screen
    public static void callIntro() {
        new IntroScreen();
    }

    public static void main(String[] args) {
        callIntro();

    }
}
