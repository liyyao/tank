package edu.hpu.liyy.tank.strategy;

import edu.hpu.liyy.tank.Bullet;
import edu.hpu.liyy.tank.Tank;
import edu.hpu.liyy.tank.strategy.FireStrategy;

public class DefaultFireStrategy implements FireStrategy {

    @Override
    public void fire(Tank t) {
        int bX = t.getX() + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int bY = t.getY() + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;
        new Bullet(bX, bY, t.getDir(), t.getGroup(), t.getGameModel());
    }
}
