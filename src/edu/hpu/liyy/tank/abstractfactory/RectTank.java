package edu.hpu.liyy.tank.abstractfactory;

import edu.hpu.liyy.tank.*;

import java.awt.*;
import java.util.Random;

public class RectTank extends BaseTank {

    private static final int SPEED = 5;
    public static final int WIDTH = ResourceMgr.goodTankU.getWidth();
    public static final int HEIGHT = ResourceMgr.goodTankU.getHeight();
    private boolean moving = true;
    private boolean living = true;
    private final Random random = new Random();
    FireStrategy fs;

    public RectTank(int x, int y, Dir dir, Group group, TankFrame tf) {
        this.setX(x);
        this.setY(y);
        this.setDir(dir);
        this.setGroup(group);
        this.setTf(tf);

        rect.x = this.getX();
        rect.y = this.getY();
        rect.width = WIDTH;
        rect.height = HEIGHT;

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
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public void paint(Graphics g) {
        if (!living) {
            this.getTf().tanks.remove(this);
        }
        Color c = g.getColor();
        g.setColor(group == Group.GOOD ? Color.RED : Color.BLUE);
        g.fillRect(x, y, 40, 40);
        g.setColor(c);
        move();
    }

    private void move() {
        if (!moving) return;
        switch (this.getDir()) {
            case LEFT:
                this.setX(this.getX() - SPEED);
                break;
            case UP:
                this.setY(this.getY() - SPEED);
                break;
            case RIGHT:
                this.setX(this.getX() + SPEED);
                break;
            case DOWN:
                this.setY(this.getY() + SPEED);
                break;
        }

        if (this.getGroup() == Group.BAD && random.nextInt(100) > 95) {
            this.fire();
        }
        if (this.getGroup() == Group.BAD && random.nextInt(100) > 95) {
            randomDir();
        }

        boundsCheck();

        rect.x = this.getX();
        rect.y = this.getY();
    }

    public void fire() {
        fs.fire(this);
    }

    public void die() {
        this.living = false;
    }

    private void randomDir() {
        this.setDir(Dir.values()[random.nextInt(4)]);
    }

    private void boundsCheck() {
        if (this.getX() < 0) this.setX(0);
        if (this.getY() < 30) this.setY(30);
        if (this.getX() > TankFrame.GAME_WIDTH - RectTank.WIDTH) this.setX(TankFrame.GAME_WIDTH - RectTank.WIDTH);
        if (this.getY() > TankFrame.GAME_HEIGHT - RectTank.HEIGHT) this.setY(TankFrame.GAME_HEIGHT - RectTank.HEIGHT);
    }
}
