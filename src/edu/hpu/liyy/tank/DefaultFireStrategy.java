package edu.hpu.liyy.tank;

import edu.hpu.liyy.tank.abstractfactory.BaseTank;

public class DefaultFireStrategy implements FireStrategy {

    @Override
    public void fire(BaseTank t) {
        int bX = t.getX() + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int bY = t.getY() + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;
        new Bullet(bX, bY, t.getDir(), t.getGroup(), t.getTf());
    }
}
