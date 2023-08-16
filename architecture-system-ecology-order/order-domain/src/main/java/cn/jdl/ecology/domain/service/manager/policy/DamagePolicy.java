package cn.jdl.ecology.domain.service.manager.policy;


import cn.jdl.ecology.domain.entity.Monster;
import cn.jdl.ecology.domain.entity.Player;
import cn.jdl.ecology.domain.entity.Weapon;

/**
 * @author chaoyang
 * @date 2022年09月08日 10:03
 */

public interface DamagePolicy {

    boolean canApply(Player player, Weapon weapon, Monster monster);

    int calculateDamage(Player player, Weapon weapon, Monster monster);
}
