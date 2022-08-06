package edu.hpu.liyy.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {

    int x = 200, y = 200;

    public TankFrame() {
        setSize(800, 600);
        setResizable(false);      //是否可改变窗口大小
        setTitle("tank war");
        setVisible(true);

        this.addKeyListener(new MyKeyListener());

        //关闭窗口
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        System.out.println("paint");
        g.fillRect(x, y, 50, 50);       //画出一个黑方块
        x += 10;
        //y += 10;
    }

    class MyKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            /*x += 20;
            repaint();*/
        }

        @Override
        public void keyReleased(KeyEvent e) {
            System.out.println("key released");
        }
    }
}
