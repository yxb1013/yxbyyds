package snakeGame2;

import javax.swing.*;

public class startgame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("贪吃蛇游戏");//创建一个窗口
        frame.setBounds(200,100,905,760);//设置窗口大小位置
        frame.setResizable(false);//设置窗口大小不可变
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置关闭按钮的作用
        frame.setVisible(true);//设置窗口可见
        gameJpanel gameJpanel = new gameJpanel();
        frame.add(gameJpanel);
    }
}
