package edu.hpu.liyy.tank;

import java.awt.*;

public class Wall extends GameObject {

    public Rectangle rect;

    public Wall(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
        this.rect = new Rectangle(x, y, w, h);
        GameModel.getInstance().add(this);
    }
    @Override
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.DARK_GRAY);
        g.fillRect(x, y, width, height);
        g.setColor(c);
    }
}
