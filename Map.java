import javax.swing.ImageIcon;
import java.awt.Image;

//represents all other elements like background
public class Map {
    int Size = 14; // our tile size is 14 if change make sure to change the dimensions of frame as
                   // well in frame class
    String map[] = new String[Size];

    final Image grass = new ImageIcon("grass.png").getImage();
    final Image wall = new ImageIcon("wall.png").getImage();
    final Image finish = new ImageIcon("finish.png").getImage();

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
    String[] Level2 = new String[] {
            "wwwwwwwwwwwwww",
            "wggggggggggggw",
            "wggwwwwwwwgggw",
            "wggggggggggggw",
            "wggggwwggggggw",
            "wggggwgggggggw",
            "wgwgggwgggwggw",
            "wgwwwggwgwgggw",
            "wgggwwggwggggw",
            "wggggwggwgggww",
            "wgggwwwggggggw",
            "wgwgggwwggwggw",
            "wggggwwwggggfw",
            "wwwwwwwwwwwwww",
    };
    String[] Level3 = new String[] {
            "wwwwwwwwwwwwww",
            "wgggggwgggwggw",
            "wwwgwgwgwgwwww",
            "wgggwgwgwgwggw",
            "wgwgwgwgwwwgww",
            "wgwgwgggggwgww",
            "wwwgwwwwwgwgww",
            "wgwgwggggggggw",
            "wgwgwgwgwgggww",
            "wgwgwgwgwgwwww",
            "wgggggggggwgww",
            "wgwgwwwgwwwgww",
            "wfwgggwgggwggw",
            "wwwwwwwwwwwwww",
    };

    Map(int n) {
        switch (n) {
            case 1:
                mapLayout(Level1);
                break;
            case 2:
                mapLayout(Level2);
                break;
            case 3:
                mapLayout(Level3);
                break;
        }
    }

    // select layout
    public void mapLayout(String[] layout) {
        for (int i = 0; i < 14; i++)
            map[i] = layout[i];
    }

    // used to scan map and allocate graphics for the map
    public String getMap(int x, int y) {
        String index = map[y].substring(x, x + 1);
        return index;
    }

}