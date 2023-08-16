package cn.jdl.ecology.application.config;

import cn.jdl.ecology.domain.enums.WeaponType;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

/**
 * @author chaoyang
 * @date 2022年09月13日 15:42
 */
@ConstructorBinding
@ConfigurationProperties(prefix = WeaponPrototype.PREFIX)
@Data
@Setter(AccessLevel.PRIVATE)
public class WeaponPrototype {

    static final String PREFIX = "weapon-proto";

    private final WeaponType weaponType = WeaponType.Sword;

    private final int damageType = 0;

    private final int damage = 60;
}
