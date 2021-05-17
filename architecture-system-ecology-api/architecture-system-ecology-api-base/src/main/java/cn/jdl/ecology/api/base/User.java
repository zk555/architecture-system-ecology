package cn.jdl.ecology.api.base;

import lombok.Data;

import java.io.Serializable;

/**
 * @author DaoDao
 */
@Data
public class User implements Serializable {

    private Long id;

    private String username;

    private String nickname;

    private String phone;

    private String email;

    private String avatar;

    private Long type;

    private String introduction;

    private String sysOrgNo;

}
