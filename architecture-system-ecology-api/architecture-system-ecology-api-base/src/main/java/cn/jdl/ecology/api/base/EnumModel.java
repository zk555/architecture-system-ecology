package cn.jdl.ecology.api.base;

import lombok.Data;

import java.io.Serializable;

/**
 * @author DaoDao
 */
@Data
public class EnumModel implements Serializable {

    /**
     * 枚举名称
     */
    private String name;
    /**
     * 枚举编码
     */
    private String key;
    /**
     * 枚举说明
     */
    private String value;

}
