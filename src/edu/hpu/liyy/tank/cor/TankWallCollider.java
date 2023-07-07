package edu.hpu.liyy.tank.cor;

import edu.hpu.liyy.tank.GameObject;
import edu.hpu.liyy.tank.Tank;
import edu.hpu.liyy.tank.Wall;

public class TankWallCollider implements Collider {
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Tank && o2 instanceof Wall) {
            Tank t = (Tank) o1;
            Wall w = (Wall) o2;
            if (t.getRect().intersects(w.rect)) {
                t.resetLastPosition();
            }
        } else if (o1 instanceof Wall && o2 instanceof Tank) {
            return collide(o2, o1);
        }
        return true;
    }
}
