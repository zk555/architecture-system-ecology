package cn.jdl.ecology.repository.impl;

import cn.jdl.ecology.domain.entity.Weapon;
import cn.jdl.ecology.persistence.mapper.WeaponMapper;
import cn.jdl.ecology.persistence.po.WeaponPO;
import cn.jdl.ecology.repository.WeaponRepository;
import cn.jdl.ecology.repository.assemble.WeaponAssembler;
import cn.jdl.ecology.types.WeaponId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * @author chaoyang
 * @date 2022年09月07日 11:11
 */
@Repository
@RequiredArgsConstructor
public class WeaponRepositoryImpl implements WeaponRepository {


    private final WeaponMapper weaponDAO;

    private final WeaponAssembler weaponAssembler;

    @Override
    public Weapon find(WeaponId weaponId) {
        WeaponPO orderDO = weaponDAO.selectById(weaponId.getId());
        return weaponAssembler.toWeapon(orderDO);
    }

    @Override
    public void cache(Weapon sword) {
        WeaponPO weaponPO = weaponAssembler.fromWeapon(sword);
        weaponDAO.insert(weaponPO);
    }
}
