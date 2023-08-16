package cn.jdl.ecology.domain.service;


import cn.jdl.ecology.domain.entity.Monster;
import cn.jdl.ecology.domain.entity.Player;

/**
 * @author chaoyang
 * @date 2022年09月07日 11:01
 * 攻击行为
 */

public interface ICombatService {

    void performAttack(Player player, Monster monster);

}
