package edu.hpu.liyy.tank;

import edu.hpu.liyy.tank.abstractfactory.BaseExplode;

import java.awt.*;

public class Explode extends BaseExplode {

    public static int WIDTH = ResourceMgr.explodes[0].getWidth();
    public static int HEIGHT = ResourceMgr.explodes[0].getHeight();

    private int x, y;
    //private boolean living = true;
    TankFrame tf = null;
    private int step = 0;

    public Explode(int x, int y, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.tf = tf;
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(ResourceMgr.explodes[step++], x, y, null);
        if (step >= ResourceMgr.explodes.length) {
            tf.explodes.remove(this);
        }
    }
}
