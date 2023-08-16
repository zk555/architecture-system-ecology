package cn.jdl.ecology.domain.service.manager.policy.impl;


import cn.jdl.ecology.domain.entity.Player;
import cn.jdl.ecology.domain.entity.Weapon;
import cn.jdl.ecology.domain.enums.PlayerClass;
import cn.jdl.ecology.domain.enums.WeaponType;
import cn.jdl.ecology.domain.service.manager.policy.EquipmentPolicy;

/**
 * @author chaoyang
 * @date 2022年09月07日 10:28
 */

public class DragoonEquipmentPolicy implements EquipmentPolicy {

    @Override
    public boolean canApply(Player player, Weapon weapon) {
        return player.getPlayerClass() == PlayerClass.Dragoon;
    }

    @Override
    public boolean canEquip(Player player, Weapon weapon) {
        return weapon.getWeaponType() == WeaponType.Sword;
    }
}
