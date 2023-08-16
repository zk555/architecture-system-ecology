package cn.jdl.ecology.types;

import cn.jdl.ecology.repository.Identifier;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class OrderId implements Identifier {

    Long id;

}
