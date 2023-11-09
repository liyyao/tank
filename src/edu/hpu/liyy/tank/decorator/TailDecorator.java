package edu.hpu.liyy.tank.decorator;

import edu.hpu.liyy.tank.GameObject;

import java.awt.*;

public class TailDecorator extends GODecorator {

    public TailDecorator(GameObject go) {
        super(go);
    }

    @Override
    public void paint(Graphics g) {
        this.x = go.x;
        this.y = go.y;
        this.width = go.width;
        this.height = go.height;
        go.paint(g);
        Color c = g.getColor();
        g.setColor(Color.BLUE);
        g.drawLine(go.x, go.y, go.x + go.width, go.y + go.height);
        g.setColor(c);
    }
}
