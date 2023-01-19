import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Instructions extends Frame implements ActionListener {
    JFrame jf = new JFrame("Maze");
    JPanel mypanel;

    Instructions() {
        jf.setVisible(true);

        mypanel = new JPanel();
        mypanel.setVisible(true);
        ImageIcon i = new ImageIcon("instructions.png");
        mypanel.setBackground(Color.BLACK);

        mypanel.add(new JLabel(i));
        JButton continueButton = new JButton("Continue");
        mypanel.add(continueButton);
        continueButton.addActionListener(this);
        this.jf.add(mypanel);
        this.setDefault(jf);

    }

    // generates new instance for main class
    public void actionPerformed(ActionEvent ae) {
        jf.dispose();
        new Main(1);

    }

}
