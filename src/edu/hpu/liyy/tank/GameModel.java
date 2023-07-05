package edu.hpu.liyy.tank;

import edu.hpu.liyy.tank.cor.BulletTankCollider;
import edu.hpu.liyy.tank.cor.Collider;
import edu.hpu.liyy.tank.cor.ColliderChain;
import edu.hpu.liyy.tank.cor.TankTankCollider;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameModel {

    Tank myTank = new Tank(200, 500, Dir.UP, Group.GOOD, this);
    /*List<Bullet> bullets = new ArrayList<>();
    List<Tank> tanks = new ArrayList<>();
    List<Explode> explodes = new ArrayList<>();*/
    private List<GameObject> objects = new ArrayList<>();
    Collider collider = new BulletTankCollider();
    Collider collider2 = new TankTankCollider();
    ColliderChain colliderChain = new ColliderChain();

    public GameModel() {
        int initTankCount = Integer.parseInt((String) PropertyMgr.get("initTankCount"));

        //初始化敌方坦克
        for (int i = 0; i < initTankCount; i++) {
            add(new Tank(50 + i * 80, 200, Dir.DOWN, Group.BAD, this));
        }
    }

    public void add(GameObject go) {
        this.objects.add(go);
    }

    public void remove(GameObject go) {
        this.objects.remove(go);
    }

    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.WHITE);
        /*g.drawString("子弹的数量：" + bullets.size(), 10, 60);
        g.drawString("敌人的数量：" + tanks.size(), 10, 80);
        g.drawString("爆炸的数量：" + explodes.size(), 10, 100);*/
        g.setColor(c);

        myTank.paint(g);
        for (int i = 0; i < objects.size(); i++) {
            objects.get(i).paint(g);
        }

        //互相碰撞
        for (int i = 0; i < objects.size(); i++) {
            for (int j = i + 1; j < objects.size(); j++) {
                GameObject o1 = objects.get(i);
                GameObject o2 = objects.get(j);
                /*collider.collide(o1, o2);
                collider2.collide(o1, o2);*/
                colliderChain.collide(o1, o2);
            }
        }
        /*for (int i = 0; i < bullets.size(); i++) {
            for (int j = 0; j < tanks.size(); j++) {
                bullets.get(i).collideWith(tanks.get(j));
            }
        }*/
    }

    public Tank getMainTank() {
        return myTank;
    }
}
