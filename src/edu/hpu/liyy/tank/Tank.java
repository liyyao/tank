package edu.hpu.liyy.tank;

import edu.hpu.liyy.tank.strategy.DefaultFireStrategy;
import edu.hpu.liyy.tank.strategy.FireStrategy;

import java.awt.*;
import java.util.Random;

public class Tank extends GameObject {

    int oldX, oldY;
    Dir dir = Dir.DOWN;
    private static final int SPEED = 5;
    private boolean moving = true;
    private boolean living = true;
    private final Random random = new Random();
    Group group = Group.BAD;
    private Rectangle rect = new Rectangle();
    FireStrategy fs;

    public Tank(int x, int y, Dir dir, Group group) {
        this.x = x;
        this.y = y;
        this.width = ResourceMgr.goodTankU.getWidth();
        this.height = ResourceMgr.goodTankU.getHeight();
        this.dir = dir;
        this.group = group;

        rect.x = this.x;
        rect.y = this.y;
        rect.width = this.width;
        rect.height = this.height;

        if (group == Group.GOOD) {
            String goodFS = (String) PropertyMgr.get("goodFS");
            try {
                fs = (FireStrategy) Class.forName(goodFS).newInstance();
            } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        } else {
            fs = new DefaultFireStrategy();
        }
        GameModel.getInstance().add(this);
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Dir getDir() {
        return dir;
    }

    public int getOldX() {
        return oldX;
    }

    public void setOldX(int oldX) {
        this.oldX = oldX;
    }

    public int getOldY() {
        return oldY;
    }

    public void setOldY(int oldY) {
        this.oldY = oldY;
    }

    public void paint(Graphics g) {
        if (!living) {
            GameModel.getInstance().remove(this);
        }
        switch (dir) {
            case LEFT:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankL : ResourceMgr.badTankL, x, y, null);
                break;
            case UP:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankU : ResourceMgr.badTankU, x, y, null);
                break;
            case RIGHT:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankR : ResourceMgr.badTankR, x, y, null);
                break;
            case DOWN:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankD : ResourceMgr.badTankD, x, y, null);
                break;
        }
        move();
    }

    private void move() {
        //记录移动之前的位置
        oldX = x;
        oldY = y;
        if (!moving) return;
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

        if (this.group == Group.BAD && random.nextInt(100) > 95) {
            this.fire();
        }
        if (this.group == Group.BAD && random.nextInt(100) > 95) {
            randomDir();
        }

        boundsCheck();

        rect.x = this.x;
        rect.y = this.y;
    }

    public void fire() {
        fs.fire(this);
    }

    public void die() {
        this.living = false;
    }

    private void randomDir() {
        this.dir = Dir.values()[random.nextInt(4)];
    }

    private void boundsCheck() {
        if (this.x < 0) x = 0;
        if (this.y < 30) y = 30;
        if (this.x > TankFrame.GAME_WIDTH - this.width) x = TankFrame.GAME_WIDTH - this.width;
        if (this.y > TankFrame.GAME_HEIGHT - this.height) y = TankFrame.GAME_HEIGHT - this.height;
    }

    public Rectangle getRect() {
        return rect;
    }

    public void stop() {
        moving = false;
    }

    public void resetLastPosition() {
        this.x = this.oldX;
        this.y = this.oldY;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }
}
