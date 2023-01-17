import java.awt.event.*;
import java.awt.event.KeyEvent;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.*;

public class Board extends JPanel implements ActionListener {
    Timer timer;
    Map m;
    Player p;
    String message = "";
    boolean gameOver = false;

    // start timer of swing class
    // using timer to repeat the action every 25 milliseconds
    public Board() {
        m = new Map();
        p = new Player();
        //
        addKeyListener(new al());
        setFocusable(true);
        timer = new Timer(25, this);

        timer.start();
    }

    public void actionPerformed(ActionEvent ae) {
        if (m.getMap(p.getTileX(), p.getTileY()).equals("f")) {
            gameOver = true;
        }
        repaint();
    }

    public void paint(Graphics g) {
        super.paint(g);
        // g.setColor(Color.red);
        // g.fillRect(45, 60, 32, 32);
        if (!gameOver) {
            for (int y = 0; y < m.Size; y++) {
                for (int x = 0; x < m.Size; x++) {
                    if (m.getMap(x, y).equals("f")) {
                        g.drawImage(m.finish, x * 32, y * 32, null);
                    }
                    if (m.getMap(x, y).equals("g")) {
                        // since grass and walls are 32 pixels each
                        g.drawImage(m.grass, x * 32, y * 32, null);
                    }
                    if (m.getMap(x, y).equals("w")) {
                        g.drawImage(m.wall, x * 32, y * 32, null);
                    }

                }
            }

            g.drawImage(p.getPlayer(), p.getTileX() * 32, p.getTileY() * 32, null);
            repaint();
        } else
            g.drawString("YOU WIN!!!", 200, 200);
    }

    class al extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {

            int keycode = e.getKeyCode();

            if (keycode == KeyEvent.VK_W || keycode == KeyEvent.VK_UP) {
                if (!m.getMap(p.tileX, p.tileY - 1).equals("w"))
                    p.move(0, -1);
            }
            if (keycode == KeyEvent.VK_S || keycode == KeyEvent.VK_DOWN) {
                if (!m.getMap(p.tileX, p.tileY + 1).equals("w"))
                    p.move(0, 1);
            }
            if (keycode == KeyEvent.VK_A || keycode == KeyEvent.VK_LEFT) {
                if (!m.getMap(p.tileX - 1, p.tileY).equals("w"))
                    p.move(-1, 0);
            }
            if (keycode == KeyEvent.VK_D || keycode == KeyEvent.VK_RIGHT) {
                if (!m.getMap(p.tileX + 1, p.tileY).equals("w"))
                    p.move(1, 0);
            }

        }

        public void keyReleased(KeyEvent e) {

        }

        public void keyTyped(KeyEvent e) {
        }
    }
}