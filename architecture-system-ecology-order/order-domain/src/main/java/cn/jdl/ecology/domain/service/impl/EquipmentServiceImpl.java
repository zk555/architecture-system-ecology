package cn.jdl.ecology.domain.service.impl;

import cn.jdl.ecology.domain.entity.Player;
import cn.jdl.ecology.domain.entity.Weapon;
import cn.jdl.ecology.domain.service.EquipmentService;
import cn.jdl.ecology.domain.service.manager.EquipmentManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author chaoyang
 * @date 2022年09月07日 10:14
 */
@Service
@RequiredArgsConstructor
public class EquipmentServiceImpl implements EquipmentService {

    private final EquipmentManager equipmentManager;
    @Override
    public boolean canEquip(Player player, Weapon weapon) {
        return equipmentManager.canEquip(player, weapon);
    }
}
