package cn.jdl.ecology.domain.entity;

import cn.jdl.ecology.domain.enums.MonsterClass;
import cn.jdl.ecology.types.Health;
import cn.jdl.ecology.types.MonsterId;
import cn.jdl.ecology.types.Transform;
import cn.jdl.ecology.types.Vector;
import lombok.Data;

/**
 * @author chaoyang
 * @date 2022年09月06日 17:07
 */
@Data
public class Monster implements Movable {

    private MonsterId id;
    private MonsterClass monsterClass; // enum
    private Health health;
    private Transform position = Transform.ORIGIN;
    private Vector velocity = Vector.ZERO;

    @Override
    public Transform getPosition() {
        return null;
    }

    @Override
    public Vector getVelocity() {
        return null;
    }

    @Override
    public void moveTo(long x, long y) {

    }

    @Override
    public void startMove(long velX, long velY) {

    }

    @Override
    public void stopMove() {

    }

    @Override
    public boolean isMoving() {
        return false;
    }

    public void takeDamage(int damage) {
        health.setHealth(health.getHealth() - damage);
    }

    public boolean isAlive() {
        return health.getHealth() > 0;

    }
}
