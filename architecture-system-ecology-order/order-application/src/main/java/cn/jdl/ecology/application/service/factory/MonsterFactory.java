package cn.jdl.ecology.application.service.factory;


import cn.jdl.ecology.domain.entity.Monster;
import cn.jdl.ecology.domain.enums.MonsterClass;
import cn.jdl.ecology.types.Health;

/**
 * @author chaoyang
 * @date 2022年09月08日 16:46
 */

public class MonsterFactory {

    public static Monster createMonster(MonsterClass monsterClass, long health) {

        Monster monster = new Monster();
        monster.setMonsterClass(monsterClass);
        monster.setHealth(new Health(health));
        return monster;
    }
}
