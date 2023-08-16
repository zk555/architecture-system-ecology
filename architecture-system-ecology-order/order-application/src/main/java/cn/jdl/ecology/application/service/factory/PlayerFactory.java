package cn.jdl.ecology.application.service.factory;

import cn.jdl.ecology.domain.entity.Player;
import cn.jdl.ecology.domain.enums.PlayerClass;

/**
 * @author chaoyang
 * @date 2022年09月08日 16:12
 */

public class PlayerFactory {

    public static Player createPlayer(){
        return new Player();
    }

    public static Player createPlayer(PlayerClass playerClass, String name) {

        Player player = new Player();
        player.setPlayerClass(playerClass);
        player.setName(name);

        return player;
    }
}
