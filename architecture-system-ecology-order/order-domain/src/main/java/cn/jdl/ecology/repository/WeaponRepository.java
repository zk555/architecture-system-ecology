package cn.jdl.ecology.repository;


import cn.jdl.ecology.domain.entity.Weapon;
import cn.jdl.ecology.types.WeaponId;

/**
 * @author chaoyang
 * @date 2022年09月07日 11:05
 */

public interface WeaponRepository {

    Weapon find(WeaponId weaponId);

    void cache(Weapon sword);
}
