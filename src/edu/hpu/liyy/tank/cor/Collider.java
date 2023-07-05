package edu.hpu.liyy.tank.cor;

import edu.hpu.liyy.tank.GameObject;

/**
 * 碰撞器，负责两个物体相撞
 */
public interface Collider {

    boolean collide(GameObject o1, GameObject o2);
}
