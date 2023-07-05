package edu.hpu.liyy.tank.cor;

import edu.hpu.liyy.tank.Bullet;
import edu.hpu.liyy.tank.Explode;
import edu.hpu.liyy.tank.GameObject;
import edu.hpu.liyy.tank.Tank;

/**
 * 子弹和坦克相撞
 */
public class TankTankCollider implements Collider {
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Tank && o2 instanceof Tank) {
            Tank tank1 = (Tank) o1;
            Tank tank2 = (Tank) o2;
            /*if (tank1.getGroup() == tank2.getGroup()) {
                return;
            }*/
            if (tank1.getRect().intersects(tank2.getRect())) {
                tank1.resetLastPosition();
                tank2.resetLastPosition();
            }
        }
        return true;
    }
}
