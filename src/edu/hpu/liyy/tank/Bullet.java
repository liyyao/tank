package edu.hpu.liyy.tank;

import java.awt.*;

public class Bullet extends GameObject {

    private static final int SPEED = 10;
    public static final int WIDTH = ResourceMgr.bulletD.getWidth();
    public static final int HEIGHT = ResourceMgr.bulletD.getHeight();
    private Dir dir;
    private boolean living = true;
    private Group group = Group.BAD;
    Rectangle rect = new Rectangle();

    public Bullet(int x, int y, Dir dir, Group group) {
        this.x = x;
        this.y = y;
        this.width = WIDTH;
        this.height = HEIGHT;
        this.dir = dir;
        this.group = group;

        rect.x = this.x;
        rect.y = this.y;
        rect.width = this.width;
        rect.height = this.height;
        GameModel.getInstance().add(this);
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public void paint(Graphics g) {
        if (!living) {
            GameModel.getInstance().remove(this);
        }
        switch (dir) {
            case LEFT:
                g.drawImage(ResourceMgr.bulletL, x, y, null);
                break;
            case UP:
                g.drawImage(ResourceMgr.bulletU, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.bulletR, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.bulletD, x, y, null);
                break;
        }
        move();
    }

    private void move() {
        switch (dir) {
            case LEFT:
                x -= SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
        }

        rect.x = this.x;
        rect.y = this.y;

        if (x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) {
            living = false;
        }
    }

    public void die() {
        this.living = false;
    }

    public Rectangle getRect() {
        return rect;
    }
}
