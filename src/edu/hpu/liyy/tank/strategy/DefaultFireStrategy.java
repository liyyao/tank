package edu.hpu.liyy.tank.strategy;

import edu.hpu.liyy.tank.Bullet;
import edu.hpu.liyy.tank.GameModel;
import edu.hpu.liyy.tank.Tank;
import edu.hpu.liyy.tank.decorator.RectDecorator;
import edu.hpu.liyy.tank.decorator.TailDecorator;
import edu.hpu.liyy.tank.strategy.FireStrategy;

public class DefaultFireStrategy implements FireStrategy {

    @Override
    public void fire(Tank t) {
        int bX = t.getX() + t.getWidth() / 2 - Bullet.WIDTH / 2;
        int bY = t.getY() + t.getHeight() / 2 - Bullet.HEIGHT / 2;
        GameModel.getInstance().add(new RectDecorator(new TailDecorator(new Bullet(bX, bY, t.getDir(), t.getGroup()))));
    }
}
