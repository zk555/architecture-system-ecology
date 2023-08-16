package cn.jdl.ecology.domain.service.manager;

import cn.jdl.ecology.domain.entity.Monster;
import cn.jdl.ecology.domain.entity.Player;
import cn.jdl.ecology.domain.entity.Weapon;
import cn.jdl.ecology.domain.service.manager.policy.DamagePolicy;
import cn.jdl.ecology.domain.service.manager.policy.impl.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chaoyang
 * @date 2022年09月07日 11:06
 */
// 策略优先级管理
@Component
public class DamageManager {
    private static final List<DamagePolicy> POLICIES = new ArrayList<>();
    static {
        POLICIES.add(new DragoonPolicy());
        POLICIES.add(new DragonImmunityPolicy());
        POLICIES.add(new OrcResistancePolicy());
        POLICIES.add(new ElfResistancePolicy());
        POLICIES.add(new PhysicalDamagePolicy());
        POLICIES.add(new DefaultDamagePolicy());
    }

    public int calculateDamage(Player player, Weapon weapon, Monster monster) {
        for (DamagePolicy policy : POLICIES) {
            if (!policy.canApply(player, weapon, monster)) {
                continue;
            }
            return policy.calculateDamage(player, weapon, monster);
        }
        return 0;
    }
}
