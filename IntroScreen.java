import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

/**
 * Main
 */
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
        jf.dispose();
        // mypanel.add(new JLabel("gameIcon.png"));
        new Instructions();
    }

}