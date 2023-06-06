package edu.hpu.liyy.tank.abstractfactory;

import edu.hpu.liyy.tank.Dir;
import edu.hpu.liyy.tank.Group;
import edu.hpu.liyy.tank.TankFrame;

public abstract class GameFactory {

    public abstract BaseTank createTank(int x, int y, Dir dir, Group group, TankFrame tf);

    public abstract BaseExplode createExplode(int x, int y, TankFrame tf);

    public abstract BaseBullet createBullet(int x, int y, Dir dir, Group group, TankFrame tf);
}
