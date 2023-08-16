package cn.jdl.ecology.repository.snapshot.util;


import cn.jdl.ecology.repository.Aggregate;
import cn.jdl.ecology.repository.Identifier;

/**
 * @author chaoyang
 * @date 2022年09月03日 21:51
 */

public class ReflectionUtils {

    public static <T extends Aggregate<ID>, ID extends Identifier> void writeField(String idField, T aggregate, ID id) {

    }

}
