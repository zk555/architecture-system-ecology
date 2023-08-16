package cn.jdl.ecology.types;

import lombok.Value;

@Value
public class Vector {
    public static final Vector ZERO = new Vector(0, 0);
    long x;
    long y;
}
