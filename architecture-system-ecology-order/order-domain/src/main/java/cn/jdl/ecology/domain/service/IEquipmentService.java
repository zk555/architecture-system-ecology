package cn.jdl.ecology.domain.service;


import cn.jdl.ecology.domain.entity.Player;
import cn.jdl.ecology.domain.entity.Weapon;

/**
 * @author chaoyang
 * @date 2022年09月07日 09:57
 * 装备行为
 */

public interface IEquipmentService {
    boolean canEquip(Player player, Weapon weapon);
}
