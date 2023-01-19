import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;

//IntroScreen class responsible for displaying the introduction screen, disposed when clicked on button
public class IntroScreen extends Frame implements ActionListener {
    JFrame jf;

    JPanel mypanel;

    IntroScreen() {
        // create a frame
        jf = new JFrame("Maze Game");
        jf.setVisible(true);
        this.displayIntroScreen();
        this.setDefault(jf);
    }

    public void displayIntroScreen() {
        // create a panel to display intro screen
        mypanel = new JPanel();
        mypanel.setVisible(true);
        ImageIcon introImage = new ImageIcon("introScreenimg.png");

        mypanel.add(new JLabel(introImage));
        mypanel.setBackground(Color.white);
        JButton startButton = new JButton(new ImageIcon("button.png"));
        // action listener to listen to button click
        startButton.addActionListener(this);
        mypanel.add(startButton);

        jf.getContentPane().setBackground(Color.WHITE);

        this.jf.add(mypanel);

    }

    public void actionPerformed(ActionEvent ae) {
        // dispose this screen
        jf.dispose();
        new Instructions();
    }

}