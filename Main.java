import javax.swing.JFrame;

public class Main extends Frame {
    JFrame mainFrame;

    Main() {
        mainFrame = new JFrame();
        mainFrame.setVisible(true);
        this.setDefault(mainFrame);

        mainFrame.add(new Board());
    }

    public static void callIntro() {
        new IntroScreen();
    }

    public static void main(String[] args) {
        callIntro();

    }
}
