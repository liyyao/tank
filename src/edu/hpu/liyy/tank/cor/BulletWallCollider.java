package edu.hpu.liyy.tank.cor;

import edu.hpu.liyy.tank.Bullet;
import edu.hpu.liyy.tank.GameObject;
import edu.hpu.liyy.tank.Wall;

public class BulletWallCollider implements Collider {
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Bullet && o2 instanceof Wall) {
            Bullet b = (Bullet) o1;
            Wall w = (Wall) o2;
            if (b.getRect().intersects(w.rect)) {
                b.die();
            }
        } else if (o1 instanceof Wall && o2 instanceof Bullet) {
            return collide(o2, o1);
        }
        return true;
    }
}
