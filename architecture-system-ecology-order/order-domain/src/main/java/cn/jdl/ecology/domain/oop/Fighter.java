package cn.jdl.ecology.domain.oop;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author chaoyang
 * @date 2022年09月05日 10:35
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class Fighter extends Player {



    private String name;

    public Fighter(String name) {
        this.name = name;
    }
}
