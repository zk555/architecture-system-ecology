package cn.jdl.ecology.domain.service.impl;

import cn.jdl.ecology.domain.entity.Monster;
import cn.jdl.ecology.domain.entity.Player;
import cn.jdl.ecology.domain.entity.Weapon;
import cn.jdl.ecology.domain.service.ICombatService;
import cn.jdl.ecology.domain.service.manager.DamageManager;
import cn.jdl.ecology.repository.WeaponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author chaoyang
 * @date 2022年09月07日 11:02
 */
@RequiredArgsConstructor
@Service
public class CombatService implements ICombatService {

    private final WeaponRepository weaponRepository;
    private final DamageManager damageManager;

    @Override
    public void performAttack(Player player, Monster monster) {
        Weapon weapon = weaponRepository.find(player.getWeaponId());
        int damage = damageManager.calculateDamage(player, weapon, monster);
        if (damage > 0) {
            monster.takeDamage(damage); // （Note 1）在领域服务里变更Monster
        }
        // 省略掉Player和Weapon可能受到的影响
    }

}
