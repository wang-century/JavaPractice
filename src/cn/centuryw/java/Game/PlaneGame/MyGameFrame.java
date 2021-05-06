package cn.centuryw.java.Game.PlaneGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author centuryw
 * @version 1.0
 * @description: 飞机游戏主窗口
 * @date 2021/5/6 下午3:00
 */
public class MyGameFrame extends JFrame {
    /**
     * @description: 初始化窗口
     * @return: void
     * @author centuryw
     * @date: 2021/5/6 下午3:02
     */
    public void launchFrame(){
        setTitle("飞机大战");   // 窗口标题
        setVisible(true);   // 窗口可见
        setSize(600,400);   // 窗口大小
        setLocation(600,400);   // 窗口位置
        // 监听关闭事件
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0); // 退出程序
            }
        });
    }

    /**
     * @description: 画窗口
     * @param: g 画笔
     * @return: void
     * @author centuryw
     * @date: 2021/5/6 下午3:09
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Color colorDefault = g.getColor();
        g.setColor(Color.GRAY);
        g.drawLine(10,40,30,30);
        g.drawRect(100,100,100,100);
        g.drawOval(100,100,100,100);
        g.drawString("This is a test string",200,200);
        g.setColor(colorDefault);   //

    }

    public static void main(String[] args) {
        MyGameFrame f = new MyGameFrame();
        f.launchFrame();
    }

}
