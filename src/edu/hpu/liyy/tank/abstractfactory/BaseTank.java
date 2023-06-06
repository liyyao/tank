package edu.hpu.liyy.tank.abstractfactory;

import edu.hpu.liyy.tank.Dir;
import edu.hpu.liyy.tank.Group;
import edu.hpu.liyy.tank.TankFrame;

import java.awt.*;

public abstract class BaseTank {
    int x, y;
    Group group = Group.BAD;
    Dir dir = Dir.DOWN;
    TankFrame tf = null;

    public Rectangle rect = new Rectangle();

    public abstract void paint(Graphics g);

    public abstract void die();

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
        return this.group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public void setTf(TankFrame tf) {
        this.tf = tf;
    }

    public TankFrame getTf() {
        return this.tf;
    }

    public Dir getDir() {
        return dir;
    }
}
