package cn.jdl.ecology.domain.service.manager.policy;


import cn.jdl.ecology.domain.entity.Player;
import cn.jdl.ecology.domain.entity.Weapon;

/**
 *
 * 策略优先级
 * @author chaoyang
 * @date 2022年09月07日 10:21
 */

public interface EquipmentPolicy {
    boolean canApply(Player player, Weapon weapon);

    boolean canEquip(Player player, Weapon weapon);

}
