package cn.jdl.ecology.repository.snapshot.util;


import cn.jdl.ecology.repository.Aggregate;
import cn.jdl.ecology.repository.Identifier;
import cn.jdl.ecology.repository.snapshot.EntityDiff;

/**
 * @author chaoyang
 * @date 2022年09月03日 21:49
 */

public class DiffUtils {
    public static <T extends Aggregate<ID>, ID extends Identifier> EntityDiff diff(T snapshot, T aggregate) {
        return null;
    }
}
