package cn.jdl.ecology.repository.snapshot;

/**
 * @author chaoyang
 * @date 2022年09月03日 21:45
 */

public class Diff {
    public DiffType getType() {
        return DiffType.Empty;
    }

    public Object getOldValue() {
        return null;
    }

    public Object getNewValue() {
        return null;
    }
}
