package cn.jdl.ecology.domain.oop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author chaoyang
 * @date 2022年09月05日 10:36
 */
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class Mage extends Player {

    private String name;

}
