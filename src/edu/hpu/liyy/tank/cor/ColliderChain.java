package edu.hpu.liyy.tank.cor;

import com.sun.deploy.util.StringUtils;
import edu.hpu.liyy.tank.GameObject;
import edu.hpu.liyy.tank.PropertyMgr;

import java.util.LinkedList;
import java.util.List;

/**
 * 碰撞器链
 */
public class ColliderChain implements Collider {
    private List<Collider> colliderList = new LinkedList<>();

    public ColliderChain() {
        String colliders = (String) PropertyMgr.get("colliders");
        if (colliders != null && !"".equals(colliders)) {
            String[] colliderClassArr = colliders.split(",");
            for (String clazz : colliderClassArr) {
                Collider collider = null;
                try {
                    collider = (Collider) Class.forName(clazz).newInstance();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                add(collider);
            }
        }
    }

    public void add(Collider c) {
        colliderList.add(c);
    }

    public boolean collide(GameObject o1, GameObject o2) {
        for (Collider collider : colliderList) {
            boolean result = collider.collide(o1, o2);
            if (!result) {
                return false;
            }
        }
        return true;
    }
}
