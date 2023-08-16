package cn.jdl.ecology.domain.entity;

import cn.jdl.ecology.domain.enums.WeaponType;
import cn.jdl.ecology.types.WeaponId;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author chaoyang
 * @date 2022年09月06日 17:08
 */
@Data
@AllArgsConstructor
public class Weapon {

    private WeaponId id;
    private String name;
    private WeaponType weaponType; // enum
    private int damage;
    private int damageType; // 0 - physical, 1 - fire, 2 - ice

}
