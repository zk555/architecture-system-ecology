package cn.jdl.ecology.api.base;

import lombok.Data;

import java.io.Serializable;

/**
 * @author DaoDao
 */
@Data
public class OAuth2 implements Serializable {

    private String accessToken;

    private String tokenType;

    private String refreshToken;

    private Integer expiresIn;

    private String scope;

}
