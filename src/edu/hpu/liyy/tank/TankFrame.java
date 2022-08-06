package edu.hpu.liyy.tank;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {

    public TankFrame() {
        setSize(800, 600);
        setResizable(false);      //是否可改变窗口大小
        setTitle("tank war");
        setVisible(true);

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
        g.fillRect(200, 200, 50, 50);       //画出一个黑方块
    }
}
