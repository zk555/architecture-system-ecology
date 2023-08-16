package cn.jdl.ecology.domain.service.manager;

import cn.jdl.ecology.domain.entity.Player;
import cn.jdl.ecology.domain.entity.Weapon;
import cn.jdl.ecology.domain.service.manager.policy.EquipmentPolicy;
import cn.jdl.ecology.domain.service.manager.policy.impl.DefaultEquipmentPolicy;
import cn.jdl.ecology.domain.service.manager.policy.impl.DragoonEquipmentPolicy;
import cn.jdl.ecology.domain.service.manager.policy.impl.FighterEquipmentPolicy;
import cn.jdl.ecology.domain.service.manager.policy.impl.MageEquipmentPolicy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chaoyang
 * @date 2022年09月07日 10:15
 */
@Component
public class EquipmentManager {

    private static final List<EquipmentPolicy> POLICIES = new ArrayList<>();
    static {
        POLICIES.add(new FighterEquipmentPolicy());
        POLICIES.add(new MageEquipmentPolicy());
        POLICIES.add(new DragoonEquipmentPolicy());
        POLICIES.add(new DefaultEquipmentPolicy());
    }

    public boolean canEquip(Player player, Weapon weapon) {
        for (EquipmentPolicy policy : POLICIES) {
            if (!policy.canApply(player, weapon)) {
                continue;
            }
            return policy.canEquip(player, weapon);
        }
        return false;
    }

}
