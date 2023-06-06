package edu.hpu.liyy.tank.abstractfactory;

import edu.hpu.liyy.tank.Tank;

import java.awt.*;

public abstract class BaseBullet {

    public abstract void paint(Graphics g);

    public abstract void collideWith(BaseTank tank);
}
