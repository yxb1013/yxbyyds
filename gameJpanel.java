package snakeGame2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class gameJpanel extends JPanel implements KeyListener, ActionListener {
    int length;
    int[] snakex = new int[600];
    int[] snakey = new int[500];
    int jif=0;
    String fx= "R";
    int w=1;
    boolean isStart = false;//游戏是否开始
    Timer timer = new Timer(140,this);
    //定义一个食物
    int foodx;int foody;
    Random random = new Random();
    public gameJpanel(){
        length = 3;
        snakex[0] = 100;snakey[0] = 100;//第头部坐标
        snakex[1] = 75;snakey[1] = 100;//第1个身体坐标
        snakex[2] = 50;snakey[2] = 100;//第1个身体坐标
        foodx = 25*random.nextInt(36);
        foody = 25*random.nextInt(28);
        this.setFocusable(true);
        this.addKeyListener(this);
        timer.start();
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.black);
        if(fx=="R")Data.right.paintIcon(this,g,snakex[0],snakey[0]);
        if(fx=="L")Data.left.paintIcon(this,g,snakex[0],snakey[0]);
        if(fx=="U")Data.up.paintIcon(this,g,snakex[0],snakey[0]);
        if(fx=="D")Data.down.paintIcon(this,g,snakex[0],snakey[0]);
        for(int i=1;i<length;i++){
            Data.body.paintIcon(this,g,snakex[i],snakey[i]);
        }
        Data.food.paintIcon(this,g,foodx,foody);
        //提醒游戏是否开始
        if(isStart==false&&w!=0){
            g.setColor(Color.white);//设置画笔颜色
            g.setFont(new Font("微软雅黑",Font.BOLD,40));//设置字体
            g.drawString("按下空格开始游戏",300,300);
        }
        if(isStart==false&&w==0){
            g.setColor(Color.red);//设置画笔颜色
            g.setFont(new Font("微软雅黑",Font.BOLD,40));//设置字体
            g.drawString("游戏结束，请按空格键重新开始",200,300);
        }
        g.setColor(Color.WHITE);//设置画笔颜色
        g.setFont(new Font("微软雅黑",Font.BOLD,20));//设置字体
        g.drawString("分数："+(length-3)*100,750,35);
    }


    @Override
    public void keyPressed(KeyEvent e) {
        //获取按下的键盘键
        int keyCode = e.getKeyCode();
        if(keyCode ==KeyEvent.VK_SPACE&&w!=0){
            isStart=!isStart;//按下空格键开始
        }
        if(keyCode ==KeyEvent.VK_SPACE&&w==0){
            length = 3;fx="R";
            snakex[0] = 100;snakey[0] = 100;//第头部坐标
            snakex[1] = 75;snakey[1] = 100;//第1个身体坐标
            snakex[2] = 50;snakey[2] = 100;//第1个身体坐标
            isStart=!isStart;
            w=1;
        }
        //获取上下左右方向
        if(keyCode == KeyEvent.VK_UP&&fx!="D"){
            fx = "U";//当方向向上时
        }
        if(keyCode == KeyEvent.VK_DOWN&&fx!="U"){
            fx = "D";//当方向向下时
        }
        if(keyCode == KeyEvent.VK_LEFT&&fx!="R"){
            fx = "L";//当方向向左时
        }
        if(keyCode == KeyEvent.VK_RIGHT&&fx!="L"){
            fx = "R";//当方向向右时
        }
    }


    @Override//计时器执行定时操作
    public void actionPerformed(ActionEvent e) {
        if(isStart==true){
            for(int i=length-1;i>0;i--){
                snakex[i]=snakex[i-1];
                snakey[i]=snakey[i-1];
            }
            if(fx=="R"){
                snakex[0]=snakex[0]+25;
                    repaint();
            }
            if(fx=="L"){
                snakex[0]=snakex[0]-25;
                    repaint();
            }
            if(fx=="U"){
                snakey[0]=snakey[0]-25;
                    repaint();
            }
            if(fx=="D"){
                snakey[0]=snakey[0]+25;
                    repaint();
            }
            if(snakex[0]==foodx&&snakey[0]==foody){
                length++;
                snakex[length-1]=foodx-1;
                snakey[length-1]=foody-1;
                foodx = 25*random.nextInt(36);
                foody = 25*random.nextInt(28);
            }
            if(snakex[0]>=900||snakey[0]>=720||snakex[0]<0||snakey[0]<0){
                isStart=false;w=0;
            }
            for (int i=1;i<length;i++){
                if(snakex[0]==snakex[i]&&snakey[0]==snakey[i]){
                    isStart=false;w=0;
                }
            }
        }
        timer.start();//让时间动起来
    }


    @Override
    public void keyTyped(KeyEvent e) {
    }
    @Override
    public void keyReleased(KeyEvent e) {
    }
}
