package cn.jdl.ecology.application.dto;

import cn.jdl.ecology.repository.Identifier;
import lombok.Data;

/**
 * @author chaoyang
 * @date 2022年09月01日 13:16
 */
@Data
public class OrderDTO implements Identifier {

    private Long id;

    private String itemTitle;

    private String detailAddress;
}
