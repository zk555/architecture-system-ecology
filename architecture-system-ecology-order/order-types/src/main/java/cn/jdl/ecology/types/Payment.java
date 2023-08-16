package cn.jdl.ecology.types;

import lombok.Value;


@Value
public class Payment {
    Long userId;
    Long amount;
}
