package cn.jdl.ecology.domain.oop;

import lombok.Data;

/**
 * 武器
 * @author chaoyang
 * @date 2022年09月05日 10:35
 */
@Data
public abstract class Weapon {
    int damage;
    int damageType; // 0 - physical, 1 - fire, 2 - ice etc.
}
