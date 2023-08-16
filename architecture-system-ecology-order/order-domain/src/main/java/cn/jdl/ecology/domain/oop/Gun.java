package cn.jdl.ecology.domain.oop;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author chaoyang
 * @date 2022年09月05日 10:40
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Gun extends Weapon {

    private final String name;

    public Gun(String name, int damage) {
        this.name = name;
        super.damage = damage;
    }
}
