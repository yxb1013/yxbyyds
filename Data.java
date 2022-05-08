package snakeGame2;

import javax.swing.*;
import java.net.URL;

public class Data {
    public static URL upurl = Data.class.getResource("/statics/up.png");
    public static ImageIcon up = new ImageIcon(upurl);
    public static URL downurl = Data.class.getResource("/statics/down.png");
    public static ImageIcon down = new ImageIcon(downurl);
    public static URL lefturl = Data.class.getResource("/statics/left.png");
    public static ImageIcon left = new ImageIcon(lefturl);
    public static URL righturl = Data.class.getResource("/statics/right.png");
    public static ImageIcon right = new ImageIcon(righturl);
    public static URL bodyurl = Data.class.getResource("/statics/body.png");
    public static ImageIcon body = new ImageIcon(bodyurl);
    public static URL foodurl = Data.class.getResource("/statics/food.png");
    public static ImageIcon food = new ImageIcon(foodurl);
}
