package edu.hpu.liyy.tank.decorator;

import edu.hpu.liyy.tank.GameObject;

import java.awt.*;

public class RectDecorator extends GODecorator {

    public RectDecorator(GameObject go) {
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
        g.setColor(Color.WHITE);
        g.drawRect(go.x, go.y, go.width + 2, go.height + 2);
        g.setColor(c);
    }
}
