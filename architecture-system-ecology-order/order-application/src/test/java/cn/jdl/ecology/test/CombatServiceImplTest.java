package cn.jdl.ecology.test;

import cn.jdl.ecology.application.config.SwordProto;
import cn.jdl.ecology.application.config.WeaponPrototype;
import cn.jdl.ecology.application.service.factory.MonsterFactory;
import cn.jdl.ecology.application.service.factory.PlayerFactory;
import cn.jdl.ecology.application.service.factory.WeaponFactory;
import cn.jdl.ecology.domain.entity.Monster;
import cn.jdl.ecology.domain.entity.Player;
import cn.jdl.ecology.domain.entity.Weapon;
import cn.jdl.ecology.domain.enums.MonsterClass;
import cn.jdl.ecology.domain.enums.PlayerClass;
import cn.jdl.ecology.domain.service.impl.CombatService;
import cn.jdl.ecology.domain.service.impl.EquipmentService;
import cn.jdl.ecology.repository.WeaponRepository;
import cn.jdl.ecology.types.Health;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class CombatServiceImplTest extends TestCase {


    @Autowired
    private CombatService combatService;

    @Autowired
    private EquipmentService equipmentService;

    @Autowired
    private WeaponRepository weaponRepository;


    @Autowired
    private SwordProto swordProto;

    @Autowired
    private WeaponPrototype weaponPrototype;

    @Test
    @DisplayName("Dragoon attack dragon doubles damage")
    public void testDragoonSpecial() {
        // Given
        Player dragoon = PlayerFactory.createPlayer(PlayerClass.Dragoon, "Dart");
        Weapon sword = WeaponFactory.createWeaponFromPrototype(swordProto, "Soul Eater", 60);
        weaponRepository.cache(sword);
        equipmentService.canEquip(dragoon,sword);
        Monster dragon = MonsterFactory.createMonster(MonsterClass.Dragon, 100);

        // When
        combatService.performAttack(dragoon, dragon);

        // Then
        assertThat(dragon.getHealth()).isEqualTo(Health.ZERO);
        assertThat(dragon.isAlive()).isFalse();
    }

    @Test
    @DisplayName("Orc should receive half damage from physical weapons")
    public void testFighterOrc() {
        // Given
        Player fighter = PlayerFactory.createPlayer(PlayerClass.Fighter, "MyFighter");
        Weapon sword = WeaponFactory.createWeaponFromPrototype(weaponPrototype, "My Sword");
        weaponRepository.cache(sword);
        fighter.equip(sword, equipmentService);
        Monster orc = MonsterFactory.createMonster(MonsterClass.Orc, 100);

        // When
        combatService.performAttack(fighter, orc);

        // Then
        assertThat(orc.getHealth()).isEqualTo(Health.of((long) (100 - 10 / 2)));
    }
}