package cn.jdl.ecology.domain.service.manager.policy.impl;


import cn.jdl.ecology.domain.entity.Monster;
import cn.jdl.ecology.domain.entity.Player;
import cn.jdl.ecology.domain.entity.Weapon;
import cn.jdl.ecology.domain.enums.MonsterClass;
import cn.jdl.ecology.domain.enums.PlayerClass;
import cn.jdl.ecology.domain.service.manager.policy.DamagePolicy;

/**
 * @author chaoyang
 * @date 2022年09月08日 10:12
 */

public class ElfResistancePolicy implements DamagePolicy {

    @Override
    public boolean canApply(Player player, Weapon weapon, Monster monster) {
        return player.getPlayerClass() == PlayerClass.Mage &&
            monster.getMonsterClass() == MonsterClass.Elf;
    }

    @Override
    public int calculateDamage(Player player, Weapon weapon, Monster monster) {
        return weapon.getDamage() / 2;
    }
}
