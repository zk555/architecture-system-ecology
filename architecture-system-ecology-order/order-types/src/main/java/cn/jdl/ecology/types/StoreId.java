package cn.jdl.ecology.types;

import cn.jdl.ecology.repository.Identifier;
import lombok.Value;


@Value
public class StoreId implements Identifier {

    Long id;

}
