package cn.jdl.ecology.types;

import lombok.Value;

@Value
public class Transform {

    public static final Transform ORIGIN = new Transform(0, 0);
    long x;
    long y;

}
