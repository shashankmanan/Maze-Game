
import javax.swing.*;
import java.awt.*;

public class Map {
    int Size = 14;
    String map[] = new String[Size];

    Image grass = new ImageIcon("grass.png").getImage();
    Image wall = new ImageIcon("wall.png").getImage();
    Image finish = new ImageIcon("finish.png").getImage();

    String[] Level1 = new String[] {
            "wwwwwwwwwwwwww",
            "wgggwwggggwggw",
            "wgggwgwwwgwggw",
            "wgwgggggggwggw",
            "wgwgggwwwgwggw",
            "wgwgggwgggwggw",
            "wgwgggwgggwggw",
            "wgwwwggwgwgggw",
            "wgggwwggwggggw",
            "wggggwggggggww",
            "wgggwwwggggggw",
            "wgwggwggggwggw",
            "wggggggwggggfw",
            "wwwwwwwwwwwwww",
    };

    Map() {
        mapLayout(Level1);
    }

    public void mapLayout(String[] layout) {
        for (int i = 0; i < 14; i++)
            map[i] = layout[i];
    }

    public String getMap(int x, int y) {
        String index = map[y].substring(x, x + 1);
        return index;
    }

}