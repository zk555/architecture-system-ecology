package cn.jdl.ecology.application.service.factory;

import cn.jdl.ecology.application.config.SwordProto;
import cn.jdl.ecology.application.config.WeaponPrototype;
import cn.jdl.ecology.domain.entity.Weapon;

/**
 * @author chaoyang
 * @date 2022年09月08日 16:38
 */

public class WeaponFactory {


    public static Weapon createWeaponFromPrototype(SwordProto swordProto, String name, int damage){

        return new Weapon(null, name, swordProto.getWeaponType(), damage, swordProto.getDamageType());
    }

    public static Weapon createWeaponFromPrototype(WeaponPrototype proto, String newName) {

        return new Weapon(null, newName, proto.getWeaponType(), proto.getDamage(), proto.getDamageType());
    }

}
