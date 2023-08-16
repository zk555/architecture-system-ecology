package cn.jdl.ecology.domain.entity;


import cn.jdl.ecology.domain.enums.PlayerClass;
import cn.jdl.ecology.domain.service.EquipmentService;
import cn.jdl.ecology.types.PlayerId;
import cn.jdl.ecology.types.Transform;
import cn.jdl.ecology.types.Vector;
import cn.jdl.ecology.types.WeaponId;
import lombok.Data;

/**
 * @author chaoyang
 * @date 2022年09月06日 17:04
 */
@Data
public class Player implements Movable {
    private PlayerId id;
    private String name;
    private PlayerClass playerClass; // enum
    private WeaponId weaponId; // （Note 1） // 只有聚合根才能保存entity ,其它尽量保存ID
    private Transform position = Transform.ORIGIN;
    private Vector velocity = Vector.ZERO;

    public void equip(Weapon weapon, EquipmentService equipmentService) {
        if (equipmentService.canEquip(this, weapon)) {
            this.weaponId = weapon.getId();
        } else {
            throw new IllegalArgumentException("Cannot Equip: " + weapon);
        }
    }


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
        this.position = new Transform(x, y);
    }

    @Override
    public void startMove(long velocityX, long velocityY) {
        this.velocity = new Vector(velocityX, velocityY);
    }

    @Override
    public void stopMove() {
        this.velocity = Vector.ZERO;
    }

    @Override
    public boolean isMoving() {
        return this.velocity.getX() != 0 || this.velocity.getY() != 0;
    }
}
