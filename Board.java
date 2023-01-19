import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Graphics;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {
    // start timer of swing class
    // using timer to repeat the action every 25 milliseconds
    Timer timer;
    Map m;
    Player p;
    boolean gameOver = false; // turns true when character reaches finish line
    int level;

    public Board(int n) {
        switch (n) {
            case 1:
                m = new Map(1);
                break;
            case 2:
                m = new Map(2);
                break;
            case 3:
                m = new Map(3);
                break;
        }
        p = new Player();

        addKeyListener(new ActivityDetect());
        setFocusable(true);
        // generate this instant every 25 ms hence fps becomes 25ms
        timer = new Timer(25, this);

        timer.start();
        level = n;
        level++;
    }

    // check if our character reached finish line or no
    public void actionPerformed(ActionEvent ae) {
        if (m.getMap(p.playerX, p.PlayerY).equals("f")) {
            gameOver = true;
        }
        repaint();
    }

    public void paint(Graphics g) { // overrides method in superclass JPanel
        super.paint(g);
        if (!gameOver) { // while our character has not reached the finish point
            for (int y = 0; y < m.Size; y++) { // m.size set to be 14 thus our map is drawn as 14 * 14
                for (int x = 0; x < m.Size; x++) {
                    if (m.getMap(x, y).equals("f")) { // draw finish point
                        g.drawImage(m.finish, x * 32, y * 32, null);
                    }
                    if (m.getMap(x, y).equals("g")) { // draw grass
                        // since grass and walls are 32 pixels each
                        g.drawImage(m.grass, x * 32, y * 32, null);
                    }
                    if (m.getMap(x, y).equals("w")) { // draw wall
                        g.drawImage(m.wall, x * 32, y * 32, null);
                    }
                    // when using another image make sure every image is 32 pixels if not change
                    // above loop size
                }
            }
            // draw our character
            g.drawImage(p.character, p.playerX * 32, p.PlayerY * 32, null);
            repaint(); // optional
        } else {
            // stop timer else infinite loop is generated
            timer.stop();
            if (level < 4)
                JOptionPane.showMessageDialog(this, "Level " + (level - 1) + " Done!!! move on to Level " + level);
            new Main(level); // create new board with the new level
        }
    }

    // ActivityDetect class is used for detecting our keyboard actions
    class ActivityDetect extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {

            int keycode = e.getKeyCode();

            if (keycode == KeyEvent.VK_W || keycode == KeyEvent.VK_UP) {
                if (!m.getMap(p.playerX, p.PlayerY - 1).equals("w")) // collision detection
                    p.move(0, -1); // move up
            }
            if (keycode == KeyEvent.VK_S || keycode == KeyEvent.VK_DOWN) {
                if (!m.getMap(p.playerX, p.PlayerY + 1).equals("w"))
                    p.move(0, 1); // move down
            }
            if (keycode == KeyEvent.VK_A || keycode == KeyEvent.VK_LEFT) {
                if (!m.getMap(p.playerX - 1, p.PlayerY).equals("w"))
                    p.move(-1, 0); // move left
            }
            if (keycode == KeyEvent.VK_D || keycode == KeyEvent.VK_RIGHT) {
                if (!m.getMap(p.playerX + 1, p.PlayerY).equals("w"))
                    p.move(1, 0); // move right
            }

        }

        // abstract methods just override them
        public void keyReleased(KeyEvent e) {

        }

        public void keyTyped(KeyEvent e) {
        }
    }
}